CREATE TABLE `captcha_portal`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(45) NOT NULL,
  `user_account` VARCHAR(20) NOT NULL,
  `user_password` VARCHAR(200) NOT NULL,
  `access_id` VARCHAR(200) NOT NULL,
  `created_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `last_login_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC),
  UNIQUE INDEX `user_account_UNIQUE` (`user_account` ASC),
  UNIQUE INDEX `access_id_UNIQUE` (`access_id` ASC),
  INDEX `IDX_CREATED_AT` (`created_at` ASC),
  INDEX `IDX_LAST_LOGIN_AT` (`last_login_at` ASC),
  INDEX `IDX_CUPDATE_AT` (`update_at` ASC));
