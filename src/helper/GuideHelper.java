/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.GuideVoyage;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author hamid
 */
public class GuideHelper extends AbstractHelper<GuideVoyage> {

    private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem(" ISBN ", "id"),
            new AbstractHelperItem("Titre", "titre"),
            new AbstractHelperItem("Auteur ", "auteur"),
            new AbstractHelperItem("Editeur ", "editeur"),
            new AbstractHelperItem("Qte Stock ", "quantiteStock"),
            new AbstractHelperItem("Date Edition", "dateEdition"),};
    }

    public GuideHelper(JTable jTable, List<GuideVoyage> list) {
        super(titres, jTable, list);
    }

    public GuideHelper(JTable jTable) {
        super(titres, jTable);

    }
}
