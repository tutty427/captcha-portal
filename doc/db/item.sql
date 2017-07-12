CREATE TABLE `captcha_portal`.`item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `item_name` VARCHAR(45) NOT NULL,
  `item_describe` VARCHAR(300) NULL,
  `item_discount` INT NULL,
  `item_price` VARCHAR(30) NOT NULL DEFAULT -1,
  `time_limit` BIGINT NOT NULL DEFAULT -1,
  `stream_limit` BIGINT NOT NULL DEFAULT -1,
  `item_available_payway` VARCHAR(45) NULL,
  `created_at` DATETIME NULL DEFAULT now(),
  `update_at` DATETIME NULL DEFAULT now(),
  PRIMARY KEY (`id`),
  INDEX `IDX_CREATED_AT` (`created_at` ASC),
  INDEX `IDX_UPDATED_AT` (`update_at` ASC));





  '''
  test data
  '''
  insert into item(item_name,item_describe,item_discount,item_price,stream_limit,item_available_payway)values('1','www.ctrip.com',0,'4000',2000,'[-1]')
