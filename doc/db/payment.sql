CREATE TABLE `captcha_portal`.`payment_record` (
  `id` INT NOT NULL,
  `order_id` INT NOT NULL,
  `trade_no` VARCHAR(100) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT now(),
  `update_at` DATETIME NOT NULL DEFAULT now(),
  PRIMARY KEY (`id`),
  INDEX `IDX_CA` (`created_at` ASC),
  INDEX `IDX_UA` (`update_at` ASC),
  INDEX `IDX_TRADE_NO` (`trade_no` ASC),
  INDEX `IDX_ORDER_ID` (`order_id` ASC));
