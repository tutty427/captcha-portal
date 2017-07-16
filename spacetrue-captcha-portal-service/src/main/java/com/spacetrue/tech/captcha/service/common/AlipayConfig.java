package com.spacetrue.tech.captcha.service.common;

/**
 * Created by Shaw on 2017/7/12.
 */
public class AlipayConfig {


    final public static String app_id = "2017071107712648";

    final public static String merchant_private_key = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQCwzHyGHHSp6x4oGBZcm5G/6Ak1NSU3NRLwtloTQuEbVtjxhYW+Q7K9JVTL9LNnWVwBCjc+l2L75BiYF3cl//6t9bd0odczLf2UQUzjCh5BD7XP69jztR8BK+zbouQKxLxTNWyGxCdNdi9a9M5U3SegUMADe5EFOCeaW47c0lMnjJYzOIxe62WO4e6ZIm+jU2W+xNLqQPWEcYK5lma9yNESLfsw9z+b7EwYVAujSJaDAD/R9+uJNC/2NGmxPjpPk8+iJv2we8dB0tyYhpffYnOEaVl4wyIF3w5G/nOtFkItWyAHRobQDHHfl9eEOk7m1WH56NC5ltrmN6DUZXvJJaUnAgMBAAECggEBAKTEXgTKfjthQICTOjviTCnyQKqStfVGhDlLaJTszkehX5tvGZ6hDvHR2b4edhgKIoFhmOy/P2OLRxRvQf5rHlnXVrrenWU4JkxFszcgVePClWmJ3m35zURVQG/M1gPnJ6/QaS0Ln6lETIvS/HwAg46X0usr/JJFrDrhuzm21gJTJIJb8PSQ7IREv2UBTX0eo8ePKMhx5CDKAYBN4NH5qLvvXgTMOSQah9piV5gyM5YN2Prxc7iqeHlXBEbRCQbNSOGSmiWQM77d/jI/Mv7ua6jJoaSwUKXA1D2Q4MCrBTN5Q1nX6oW7P6UI62oxPbPW/Sh+Za5L7fPPEZPADwt+CVkCgYEA+azDVH195d1g1fJU82e4/nKNgy/HitvWoo81uGfNzypAjUu0OF4AhRiLpLQpr2pTi7SM+HQY63PP+YEwqgHPz0F4tTGI4Bx8KPALxZdVZvELknQ4PhmtG7lrQ62UxP2kzCEpax4r+RaZJJvuAAXTPVF15ifl6QDdSQbJ/B9BcB0CgYEAtUcYGaMkwZT0kULSUfO8gE+0HkRaTjEXCHGic9DTO2OR7jg+JUFeJAUZ1mT/Rmzafqu9fAHyWaw0OLxcHJvABVyjYvsY+O4Hl6vCj5hh1tt+1EhDfwwU3gruh641tE02uGnC35/uGt7p6nXNXe0DkGjGSHmmmXMOg6I6Rm55LxMCgYEAsSCNmr1EufSqJF49QklNhsaB+pXE/JAl30G2HNMXwWb6UMNqYaret43IU9q00AugpbY7ZHAI1dFdtGagvZt3cFPEbNdtgYDz3J8f2tgX8GYFjasB05ynoMmUfXkB2BcR+Pd1yNao35fWoZA18rIvQIswF04q33iLhKlaVpFd/UkCgYEArUMBTue2puunAfv7J+ctYPpNLqyoH5od6K0r10Rd0KKvhR/ujg83WnghpOAteXNrNq0RU6hMqdbEpwGpjJJ06usLIvzadnqTeSzqrfK4ePKb+2wCTzkN7NhH+hjRLb6rMYGsh67Flps+uiDUJBT4Vhs+gWD8kif9VGVHC7BlVU8CgYEA1uFHhF+KJe0yjR6s8fgDatHplPkEtzmoJekOQt4lJRl2dmNNix/wFIbUCT6JfveJFr2RHVa7AQITTSbJ0iLOfzHTsF59z2DaZPa8E6oZM5CNfM6Sal++WVEKMufqco5l4m92UotjJNJCazZCVLHOmgVUgEaFDz5XMthK3w3qP1I=";

    final public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsMx8hhx0qeseKBgWXJuRv+gJNTUlNzUS8LZaE0LhG1bY8YWFvkOyvSVUy/SzZ1lcAQo3Ppdi++QYmBd3Jf/+rfW3dKHXMy39lEFM4woeQQ+1z+vY87UfASvs26LkCsS8UzVshsQnTXYvWvTOVN0noFDAA3uRBTgnmluO3NJTJ4yWMziMXutljuHumSJvo1NlvsTS6kD1hHGCuZZmvcjREi37MPc/m+xMGFQLo0iWgwA/0ffriTQv9jRpsT46T5PPoib9sHvHQdLcmIaX32JzhGlZeMMiBd8ORv5zrRZCLVsgB0aG0Axx35fXhDpO5tVh+ejQuZba5jeg1GV7ySWlJwIDAQAB";

    final public static String notify_url = "http://service.spacetrue.com/captcha/api/alipayNotifyCallBack";

    final public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    final public static String sign_type = "RSA2";

    final public static String charset = "utf-8";

    final public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";

    //final public static String log_path = "C:\\";



}
