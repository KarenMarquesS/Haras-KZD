#!/bin/bash

# Variáveis de Configuração
export RESOURCE_GROUP_NAME="rg-haraskzd"
export WEBAPP_NAME="haraskzd-rm554556"
export APP_SERVICE_PLAN="planharaskzd"
export LOCATION="brazilsouth"
export RUNTIME="JAVA:17-java17"
export BRANCH="main"
export APP_INSIGHTS_NAME="ai-haraskzd"


# Criar o Plano de Serviço
az appservice plan create \
  --name "$APP_SERVICE_PLAN" \
  --resource-group "$RESOURCE_GROUP_NAME" \
  --location "$LOCATION" \
  --sku F1 \
  --is-linux


# Criar o Serviço de Aplicativo
az webapp create \
  --name "$WEBAPP_NAME" \
  --resource-group "$RESOURCE_GROUP_NAME" \
  --plan "$APP_SERVICE_PLAN" \
  --runtime "$RUNTIME"


# Habilita a autenticação Básica (SCM)
az resource update \
  --resource-group "$RESOURCE_GROUP_NAME" \
  --namespace Microsoft.Web \
  --resource-type basicPublishingCredentialsPolicies \
  --name scm \
  --parent sites/"$WEBAPP_NAME" \
  --set properties.allow=true

# Configurar as Variáveis de Ambiente necessárias do nosso App e do Application Insights
az webapp config appsettings set \
  --name "$WEBAPP_NAME" \
  --resource-group "$RESOURCE_GROUP_NAME" \
  --settings \
    SPRING_DATASOURCE_USERNAME="admsql" \
    SPRING_DATASOURCE_PASSWORD="Fiap@2tdsvms" \
    SPRING_DATASOURCE_URL="jdbc:sqlserver://sqlserver-haraskzd.database.windows.net:1433;database=haraskzddb;user=admsql@sqlserver-haraskzd;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;"


# Reiniciar o Web App
az webapp restart \
  --name "$WEBAPP_NAME" \
  --resource-group "$RESOURCE_GROUP_NAME"


