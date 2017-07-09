
CREATE TABLE `captcha_portal`.`order_record` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `item_id` INT NOT NULL,
  `user_id` VARCHAR(45) NOT NULL,
  `order_price` VARCHAR(45) NOT NULL,
  `pay_way` INT NOT NULL,
  `order_time` DATETIME NULL DEFAULT now(),
  `created_at` DATETIME NULL DEFAULT now(),
  `update_at` DATETIME NULL DEFAULT now(),
  PRIMARY KEY (`id`),
  INDEX `IDX_ITEM_ID` (`item_id` ASC),
  INDEX `IDX_USER_ID` (`user_id` ASC),
  INDEX `IDX_CREATED_AT` (`created_at` ASC),
  INDEX `IDX_UPDTE_AT` (`update_at` ASC));
