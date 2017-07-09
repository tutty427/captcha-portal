CREATE TABLE `captcha_portal`.`item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `item_name` VARCHAR(45) NOT NULL,
  `item_describe` VARCHAR(300) NULL,
  `item_discount` INT NULL,
  `time_limit` BIGINT NOT NULL DEFAULT -1,
  `stream_limit` BIGINT NOT NULL DEFAULT -1,
  `item_available_payway` VARCHAR(45) NULL,
  `created_at` DATETIME NULL DEFAULT now(),
  `update_at` DATETIME NULL DEFAULT now(),
  PRIMARY KEY (`id`),
  INDEX `IDX_CREATED_AT` (`created_at` ASC),
  INDEX `IDX_UPDATED_AT` (`update_at` ASC));
