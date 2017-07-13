CREATE TABLE `captcha_portal`.`payment_record` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(45) NOT NULL,
  `item_id` INT NOT NULL,
  `order_id` INT NOT NULL,
  `trade_no` VARCHAR(100) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT now(),
  `update_at` DATETIME NOT NULL DEFAULT now(),
  PRIMARY KEY (`id`),
  INDEX `IDX_create_at` (`created_at` ASC),
  INDEX `IDX_update_at` (`update_at` ASC),
  INDEX `IDX_Ids` (`user_id` ASC, `order_id` ASC, `item_id` ASC));
