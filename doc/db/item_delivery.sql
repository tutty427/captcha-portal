CREATE TABLE `captcha_portal`.`item_delivery` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `order_id` VARCHAR(50) NOT NULL,
  `item_id` INT NOT NULL,
  `user_id` VARCHAR(45) NOT NULL,
  `active_time` DATETIME NULL,
  `end_time` DATETIME NULL,
  `total_used_count` BIGINT NULL,
  `current_used_count` BIGINT NULL,
  `created_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  INDEX `IDX_CREATED_AT` (`created_at` ASC),
  INDEX `IDX_UPDATE_AT` (`update_at` ASC),
  INDEX `IDX_USER_ID` (`user_id` ASC),
  INDEX `IDX_ORDER_ID` (`order_id` ASC));