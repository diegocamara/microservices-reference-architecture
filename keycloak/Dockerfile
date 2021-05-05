FROM quay.io/keycloak/keycloak:12.0.1
ARG REALM_FILE=realms/realm-export.json
ENV KEYCLOAK_IMPORT=${REALM_FILE}
COPY ${REALM_FILE} /realms/
