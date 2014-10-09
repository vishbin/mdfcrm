/* Formatted on 2007/10/15 00:03 (QP5 v5.50) */
CREATE TABLE `agent` (
  `agent_id` int(11) NOT NULL auto_increment,
  `agent_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `lost_customers` int(11) default NULL,
  `open_customers` int(11) default NULL,
  `closed_customers` int(11) default NULL,
  `total_customers` int(11) default NULL,
  `insert_key` varchar(30) default NULL,
  `deleted` int(11) default NULL,
  `add_dttm` datetime default NULL,
  `update_dttm` datetime default NULL,
  `delete_dttm` datetime default NULL,
  `created_by` varchar(20) default NULL,
  `updated_by` varchar(20) default NULL,
  `transferred_customers` int(11) default NULL,
  `ticketed_customers` int(11) default NULL,
  `active` int(11) default '1',
  PRIMARY KEY  (`agent_id`)
) ENGINE=MyISAM AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;

