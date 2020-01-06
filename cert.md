1. SSL certs needed:
    - storage.googleapis.com (https://www.googleapis.com/oauth2/v3/certs)
    - api.stackexchange.com (https://api.stackexchange.com/docs/authentication)
    - generate one from openssl for our service (`openssl req -newkey rsa:2048 -new -x509 -days 365 -nodes -out sl-cert.crt -keyout sl-cert.key`)

1. Create directory `src/main/liberty/config/resources/security` for keystores
1. Move the certificates to this repo
1. For google and stackoverflow certs, do:
  ` keytool -import -trustcacerts -file <filename> -alias <doesn't matter what name you give> -keystore slts.p12 -storetype PKCS12 -storepass changeit`
1. For the self generated one, follow: https://www.wowza.com/docs/how-to-import-an-existing-ssl-certificate-and-private-key
