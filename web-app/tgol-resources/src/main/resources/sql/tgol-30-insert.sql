USE tanaguru;

INSERT IGNORE INTO `TGSI_ROLE` (`Id_Role`, `Role_Name`) VALUES
(1, 'ROLE_GUEST'),
(2, 'ROLE_USER');

INSERT IGNORE INTO `TGSI_ROLE` (`Id_Role`, `Role_Name`, `ROLE_Id_Role`) VALUES
(3, 'ROLE_ADMIN', '2');

INSERT IGNORE INTO `TGSI_SCOPE` (`Id_Scope`, `Code`, `Label`) VALUES
(1, 'GROUPOFPAGES', 'Group of pages'),
(2, 'DOMAIN', 'Domain'),
(3, 'PAGE', 'Page'),
(4, 'FILE', 'File'),
(5, 'GROUPOFFILES', 'Group of files');

INSERT IGNORE INTO `TGSI_PRODUCT` (`Id_Product`, `Code`, `Label`, `SCOPE_Id_Scope`) VALUES
(1, 'AXS_PAGES', 'Audit Pages Axs', '1'),
(2, 'AXS_DOMAIN', 'Audit Domain Axs', '2'),
(3, 'AXS_READONLY', 'Audit Read Only Axs', '1'),
(4, 'SEO_PAGES', 'Audit Pages Seo', '1'),
(5, 'SEO_DOMAIN', 'Audit Domain Seo', '2'),
(6, 'SEO_READONLY', 'Audit Read Only Seo', '1'),
(7, 'AXS_UPLOAD', 'Audit Upload Axs', '5'),
(8, 'SEO_UPLOAD', 'Audit Upload Seo', '5'),
(9, 'AXS_PAGES_UPLOAD', 'Audit Upload Axs', '1'),
(10, 'SEO_PAGES_UPLOAD', 'Audit Upload Seo', '1'),
(11, 'AXS_DOMAIN_ONLY', 'Audit Upload Axs', '2'),
(12, 'SEO_DOMAIN_ONLY', 'Audit Upload Seo', '2'),
(13, 'AXS_PAGES_DOMAIN_UPLOAD', 'Audit Upload Axs', '2'),
(14, 'SEO_PAGES_DOMAIN_UPLOAD', 'Audit Upload Seo', '2');

INSERT IGNORE INTO `TGSI_RESTRICTION_ELEMENT` (`Id_Restriction_Element`, `Cd_Restriction_Element`, `Description`) VALUES
(1, 'ACT_LIMITATION', 'The act limitation unit is the number of acts'),
(2, 'ACT_BY_IP_LIMITATION', 'The act by ip limitation unit is the number of acts in a period for a given ip.
The period is expressed in seconds and the format is \"nb_of_acts/period\"'),
(3, 'MAX_DOCUMENTS', 'This restriction limits the max number of crawled documents'),
(4, 'FORDIDDEN_REFERENTIAL', 'This restriction forbids the access to a referential'),
(5, 'DEPTH', 'This restriction limits the depth of the crawl'),
(6, 'MAX_DURATION', 'This restriction limits the duration of the crawl'),
(7, 'EXCLUSION_REGEXP', 'This restriction applies an exclusion rule on crawled Urls'),
(8, 'ACT_LIFETIME','This restriction determines the lifetime of each associated with the contract'),
(9, 'NB_OF_AUDIT_TO_DISPLAY','This restriction determines the number of audit results that can be displayed on the contract page') ;

INSERT IGNORE INTO `TGSI_RESTRICTION` (`Id_Restriction_Element`, `Restriction_Value`) VALUES
(1, '5'),
(2, '5/3600'),
(3, '100'),
(3, '10000'),
(3, '20000'),
(4, 'Seo'),
(8, '-1'),
(8, '5'),
(8, '30'),
(8, '365'),
(9, '5'),
(9, '10'),
(9, '50'),
(9, '100');