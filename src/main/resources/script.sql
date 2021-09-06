UPDATE tp_menu_item SET route='list-abonnement-cabinet'  where id=56;

UPDATE tp_menu_item SET route='list-abonnement-inscription'  where id=58;

UPDATE tp_menu_item SET route='intervenant-abonnement-cabinet'  where id=57;

INSERT INTO `tp_menu_item` (`id`, `code`, `libelle`, `parent_id`, `priorite`, `profil`, `route`) 
VALUES (68,'SEL','Intervenant contribuable',55,1,7,'intervenant-abonnement-contribuable');

UPDATE tp_menu_item SET profil=1  where id=51;
UPDATE tp_menu_item SET route='rapport-visa-cabinet'  where id=52;
UPDATE tp_menu_item SET route='rapport-rejet-cabinet'  where id=53;

INSERT INTO `tp_menu_item` (`id`, `code`, `icon`, `libelle`, `parent_id`, `priorite`, `profil`, `route`) VALUES (70, 'CA', NULL, 'Eta LINK', 0, 5, 2, 'etalink/list');
INSERT INTO `tp_menu_item` (`id`, `code`, `icon`, `libelle`, `parent_id`, `priorite`, `profil`, `route`) VALUES (69, 'DE', NULL, 'Eta LINK', 0, 5, 5, 'etalink/list');
INSERT INTO `tp_menu_item` (`id`, `code`, `icon`, `libelle`, `parent_id`, `priorite`, `profil`, `route`) VALUES (71, 'EX', NULL, 'Eta LINK', 0, 5, 3, 'etalink/list');
INSERT INTO `tp_nature_fichier` (`naf_id`, `naf_extension`, `naf_icone`, `naf_libelle`) VALUES (15, 'xlsm', NULL, 'EtaLink');
INSERT INTO `tp_nature_fichier` (`naf_id`, `naf_extension`, `naf_icone`, `naf_libelle`) VALUES (16, 'xlsm', NULL, 'FEtalink');
INSERT INTO `tp_nature_fichier` (`naf_id`, `naf_extension`, `naf_icone`, `naf_libelle`) VALUES (17, 'xlsm', NULL, 'GEtalink');
UPDATE tp_nature_fichier  SET naf_extension='xlsx' WHERE naf_id=17