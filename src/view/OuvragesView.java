package view;

import bean.BandeDessine;
import bean.GuideVoyage;
import bean.Livre;
import bean.Ouvrage;
import bean.Personne;
import bean.Revus;
import bean.Roman;
import helper.BandeDHelper;
import helper.GuideHelper;
import helper.LivreHelper;
import helper.RevusHelper;
import helper.RomanHelper;
import java.awt.Frame;
import java.awt.Image;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import service.BandesDService;
import service.LivreService;
import service.RevusService;
import service.RomanService;
import service.GuideService;
import util.Session;

/**
 *
 * @author hamid
 */
public class OuvragesView extends javax.swing.JFrame {

    //block des appels 
    RomanService romanService = new RomanService();
    LivreService livreService = new LivreService();
    RevusService revusService = new RevusService();
    GuideService guideService = new GuideService();
    BandesDService bandesDService = new BandesDService();
    RevusHelper revusHelper;
    RomanHelper romanHelper;
    LivreHelper livreHelper;
    BandeDHelper bandeDHelper;
    GuideHelper guideHelper;

    String path;

    //methode contient toutes les truc a faire lors du  premier affichage 
    public void defaultParam() throws Exception {

        romanHelper = new RomanHelper(tableRomans, romanService.listRomans());
        livreHelper = new LivreHelper(tableLivres, livreService.listLivres());
        revusHelper = new RevusHelper(revusTable, revusService.listRevus());
        bandeDHelper = new BandeDHelper(bandesDTable, bandesDService.listBandes());
        guideHelper = new GuideHelper(guidesTable, guideService.listGuides());
        panelInfoSupLivre.setVisible(false);

       
        Personne connectedPersonne = (Personne) Session.getAttribut("loadedPersonne");
        System.out.println("ha l'utilisateur connecte men ouvrage view "+connectedPersonne);
        System.out.println("ha type dial l'utilisateur connecte men ouvrage view "+connectedPersonne.getType());
        if(connectedPersonne.getType().equals("Assistant")){
            System.out.println("rah kaydkhel  el if");
            jLabel3.setVisible(false);
            jButton4.setEnabled(false);
            jButton5.setEnabled(false);
            jButton6.setEnabled(false);
        }

    }

    //methode qui va netoye notre vue 
    public void cleanView() throws Exception {

        isbnTextField.setText("");
        titreTextField.setText("");
        auteurTextField.setText("");
        editeurTextField.setText("");
        quantiteTextField.setText("");
        typeOuvrageCombobox.setSelectedItem("");
        imageLabel.setIcon(null);
        typeOuvrageCombobox.setSelectedIndex(0);

        defaultParam();

    }

    //convertir la date de java a une date sql 
    private static java.sql.Date convertUtilToSql(java.util.Date utilDate) {
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return sqlDate;
    }

    //convertir la date sql  a une date comprehensible par java  
    public static java.util.Date convertSqlToUtil(java.sql.Date sqlDate) {
        java.util.Date javaDate = new Date(sqlDate.getTime());
        return javaDate;
    }

    //pour adapter la taile  de couverture a la taille du jlabel 
    private Icon ResizeImage(String path) {
        ImageIcon imgIcon = new ImageIcon(path);
        Image img = imgIcon.getImage();
        Image imge = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
        Icon imageIcon = new ImageIcon(imge);
        return imageIcon;
    }

    //recuperer les paramettres saisie par l'utilisateur
    public Ouvrage getParam() {

        Ouvrage ouvrage = new Ouvrage();
        ouvrage.setId(isbnTextField.getText());
        ouvrage.setTitre(titreTextField.getText());
        ouvrage.setAuteur(auteurTextField.getText());
        ouvrage.setEditeur(editeurTextField.getText());
        ouvrage.setDateEdition(convertUtilToSql(dateEditionSchooser.getSelectedDate().getTime()));
        ouvrage.setQuantiteStock(new Integer(quantiteTextField.getText()));

        path = path.replace("\\", "\\\\");
        ouvrage.setCouverture(path);

        return ouvrage;
    }

    //recuperer les paramettres saisie par l'utilisateur
    public Ouvrage getParamMod() {

        Ouvrage ouvrage = new Ouvrage();
        ouvrage.setId(isbnTextField.getText());
        ouvrage.setTitre(titreTextField.getText());
        ouvrage.setAuteur(auteurTextField.getText());
        ouvrage.setEditeur(editeurTextField.getText());
        ouvrage.setDateEdition(convertUtilToSql(dateEditionSchooser.getSelectedDate().getTime()));
        ouvrage.setQuantiteStock(new Integer(quantiteTextField.getText()));

        return ouvrage;
    }

    //constructeur  
    public OuvragesView() {
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        //this.setUndecorated(true);

        initComponents();
        try {
            defaultParam();
        } catch (Exception ex) {
            Logger.getLogger(OuvragesView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        typeOuvrageCombobox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        editeurTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        auteurTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        titreTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        isbnTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        parcourir = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        dateEditionSchooser = new datechooser.beans.DateChooserCombo();
        quantiteTextField = new javax.swing.JTextField();
        panelInfoSupLivre = new javax.swing.JPanel();
        scenario = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        couleur = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        dessin = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        collection = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        ISBNRomanRech = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        titreRomanRech = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        editeurRomanRech = new javax.swing.JTextField();
        auteurRomanRech = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRomans = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableLivres = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        ISBNRomanRech4 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        auteurRomanRech4 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        titreRomanRech4 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        editeurRomanRech4 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        revusTable = new javax.swing.JTable();
        jPanel26 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        ISBNRomanRech2 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        titreRomanRech2 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        editeurRomanRech2 = new javax.swing.JTextField();
        auteurRomanRech2 = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        bandeIsbnRech = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        bandeAuteurRech = new javax.swing.JTextField();
        bandeTitreRech = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        bandeEditeurRech = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        bandesDTable = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        guidesTable = new javax.swing.JTable();
        jPanel27 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        ISBNRomanRech3 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        titreRomanRech3 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        editeurRomanRech3 = new javax.swing.JTextField();
        auteurRomanRech3 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information d'un Ouvrage", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 12))); // NOI18N
        jPanel2.setLayout(null);

        typeOuvrageCombobox.setFont(new java.awt.Font("Segoe Print", 1, 11)); // NOI18N
        typeOuvrageCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Selectionner --", "Livre", "Roman", "Bande dessinee", "Revus", "Guide de voyage" }));
        typeOuvrageCombobox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                typeOuvrageComboboxItemStateChanged(evt);
            }
        });
        typeOuvrageCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeOuvrageComboboxActionPerformed(evt);
            }
        });
        jPanel2.add(typeOuvrageCombobox);
        typeOuvrageCombobox.setBounds(27, 397, 258, 27);

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel10.setText("Type ouvrage ");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(27, 370, 100, 18);

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel8.setText("Date Edition ");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(27, 257, 96, 18);

        editeurTextField.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jPanel2.add(editeurTextField);
        editeurTextField.setBounds(27, 223, 258, 28);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel7.setText("Editeur  ");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(27, 200, 65, 17);

        auteurTextField.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jPanel2.add(auteurTextField);
        auteurTextField.setBounds(27, 166, 258, 28);

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel6.setText("Auteur");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(27, 143, 50, 17);

        titreTextField.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jPanel2.add(titreTextField);
        titreTextField.setBounds(27, 110, 258, 27);

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel9.setText("Titre");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(27, 90, 34, 19);

        isbnTextField.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
        jPanel2.add(isbnTextField);
        isbnTextField.setBounds(27, 56, 258, 28);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel5.setText("ISBN ");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(27, 36, 40, 14);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Couverture", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 12))); // NOI18N

        imageLabel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(295, 36, 286, 352);

        parcourir.setBackground(new java.awt.Color(255, 255, 255));
        parcourir.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
        parcourir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/upload.png"))); // NOI18N
        parcourir.setText("Parcourir ");
        parcourir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parcourirActionPerformed(evt);
            }
        });
        jPanel2.add(parcourir);
        parcourir.setBounds(295, 394, 286, 33);

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
        jLabel11.setText("Quantite en  Stock ");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(27, 312, 141, 18);

        dateEditionSchooser.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    dateEditionSchooser.setCalendarBackground(new java.awt.Color(51, 204, 255));
    jPanel2.add(dateEditionSchooser);
    dateEditionSchooser.setBounds(27, 281, 258, 25);

    quantiteTextField.setFont(new java.awt.Font("Segoe Print", 1, 13)); // NOI18N
    jPanel2.add(quantiteTextField);
    quantiteTextField.setBounds(27, 336, 258, 28);

    panelInfoSupLivre.setBackground(new java.awt.Color(255, 255, 255));
    panelInfoSupLivre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Infos suplementaire sur le bande_dessine", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 10))); // NOI18N

    jLabel26.setBackground(new java.awt.Color(0, 0, 0));
    jLabel26.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
    jLabel26.setText("Scenario");

    jLabel27.setBackground(new java.awt.Color(0, 0, 0));
    jLabel27.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
    jLabel27.setText("Couleur ");

    jLabel28.setBackground(new java.awt.Color(0, 0, 0));
    jLabel28.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
    jLabel28.setText("Dessin");

    jLabel29.setBackground(new java.awt.Color(0, 0, 0));
    jLabel29.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
    jLabel29.setText("collection ");

    javax.swing.GroupLayout panelInfoSupLivreLayout = new javax.swing.GroupLayout(panelInfoSupLivre);
    panelInfoSupLivre.setLayout(panelInfoSupLivreLayout);
    panelInfoSupLivreLayout.setHorizontalGroup(
        panelInfoSupLivreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelInfoSupLivreLayout.createSequentialGroup()
            .addGap(24, 24, 24)
            .addGroup(panelInfoSupLivreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelInfoSupLivreLayout.createSequentialGroup()
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addGroup(panelInfoSupLivreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(scenario, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelInfoSupLivreLayout.createSequentialGroup()
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(couleur, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(36, 36, 36)
            .addGroup(panelInfoSupLivreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelInfoSupLivreLayout.createSequentialGroup()
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(dessin, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelInfoSupLivreLayout.createSequentialGroup()
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(collection, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(44, 44, 44))
    );
    panelInfoSupLivreLayout.setVerticalGroup(
        panelInfoSupLivreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(panelInfoSupLivreLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelInfoSupLivreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(dessin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelInfoSupLivreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(scenario, javax.swing.GroupLayout.Alignment.LEADING))
                .addComponent(jLabel28))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(panelInfoSupLivreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(couleur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addComponent(collection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(37, 37, 37))
    );

    jPanel2.add(panelInfoSupLivre);
    panelInfoSupLivre.setBounds(30, 430, 550, 130);

    jPanel1.add(jPanel2);
    jPanel2.setBounds(10, 0, 600, 570);

    jPanel4.setBackground(new java.awt.Color(255, 255, 255));
    jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste des Ouvrage", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 12))); // NOI18N
    jPanel4.setLayout(null);

    jTabbedPane2.setBackground(new java.awt.Color(0, 0, 0));
    jTabbedPane2.setForeground(new java.awt.Color(255, 255, 255));
    jTabbedPane2.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N

    jPanel6.setBackground(new java.awt.Color(255, 255, 255));

    jPanel8.setBackground(new java.awt.Color(255, 255, 255));
    jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rechercher un  Roman", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 12))); // NOI18N

    jLabel12.setBackground(new java.awt.Color(0, 0, 0));
    jLabel12.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel12.setText("ISBN ");

    ISBNRomanRech.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ISBNRomanRechActionPerformed(evt);
        }
    });

    jLabel13.setBackground(new java.awt.Color(0, 0, 0));
    jLabel13.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel13.setText("Titre ");

    jLabel14.setBackground(new java.awt.Color(0, 0, 0));
    jLabel14.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel14.setText("Auteur ");

    jLabel15.setBackground(new java.awt.Color(0, 0, 0));
    jLabel15.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel15.setText("Editeur");

    javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
    jPanel8.setLayout(jPanel8Layout);
    jPanel8Layout.setHorizontalGroup(
        jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel8Layout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addComponent(jLabel12)
                    .addGap(18, 18, 18)
                    .addComponent(ISBNRomanRech, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addComponent(jLabel14)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(auteurRomanRech)))
            .addGap(18, 18, 18)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addComponent(jLabel13)
                    .addGap(18, 18, 18)
                    .addComponent(titreRomanRech, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addComponent(jLabel15)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(editeurRomanRech, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel8Layout.setVerticalGroup(
        jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel8Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(ISBNRomanRech, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(titreRomanRech, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(auteurRomanRech, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(editeurRomanRech, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel9.setBackground(new java.awt.Color(255, 255, 255));
    jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste des Romans", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 12))); // NOI18N

    tableRomans.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
    tableRomans.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    ));
    tableRomans.setAlignmentY(1.0F);
    tableRomans.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    tableRomans.setIntercellSpacing(new java.awt.Dimension(1, 2));
    tableRomans.setRowHeight(30);
    tableRomans.setSelectionBackground(new java.awt.Color(62, 64, 70));
    tableRomans.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    tableRomans.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tableRomansMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tableRomans);

    javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
    jPanel9.setLayout(jPanel9Layout);
    jPanel9Layout.setHorizontalGroup(
        jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel9Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
            .addContainerGap())
    );
    jPanel9Layout.setVerticalGroup(
        jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel9Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
            .addContainerGap())
    );

    javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
    jPanel6.setLayout(jPanel6Layout);
    jPanel6Layout.setHorizontalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel6Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel6Layout.setVerticalGroup(
        jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel6Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );

    jTabbedPane2.addTab("Romans ", jPanel6);

    jPanel7.setBackground(new java.awt.Color(255, 255, 255));

    jPanel10.setBackground(new java.awt.Color(255, 255, 255));
    jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste des Livres", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 12))); // NOI18N

    tableLivres.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
    tableLivres.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    ));
    tableLivres.setRowHeight(30);
    tableLivres.setSelectionBackground(new java.awt.Color(62, 64, 70));
    tableLivres.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tableLivresMouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(tableLivres);

    javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
    jPanel10.setLayout(jPanel10Layout);
    jPanel10Layout.setHorizontalGroup(
        jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel10Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane2)
            .addContainerGap())
    );
    jPanel10Layout.setVerticalGroup(
        jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel10Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
            .addContainerGap())
    );

    jPanel11.setBackground(new java.awt.Color(255, 255, 255));
    jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rechercher un Livre ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 12))); // NOI18N

    jLabel17.setBackground(new java.awt.Color(0, 0, 0));
    jLabel17.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel17.setText("ISBN ");

    auteurRomanRech4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            auteurRomanRech4ActionPerformed(evt);
        }
    });

    jLabel18.setBackground(new java.awt.Color(0, 0, 0));
    jLabel18.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel18.setText("Auteur ");

    jLabel19.setBackground(new java.awt.Color(0, 0, 0));
    jLabel19.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel19.setText("Titre");

    jLabel20.setBackground(new java.awt.Color(0, 0, 0));
    jLabel20.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel20.setText("Editeur ");

    javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
    jPanel11.setLayout(jPanel11Layout);
    jPanel11Layout.setHorizontalGroup(
        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addComponent(jLabel18)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(auteurRomanRech4, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addComponent(jLabel17)
                    .addGap(18, 18, 18)
                    .addComponent(ISBNRomanRech4)))
            .addGap(33, 33, 33)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel20)
                .addComponent(jLabel19))
            .addGap(18, 18, 18)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(editeurRomanRech4, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addComponent(titreRomanRech4))
            .addContainerGap())
    );
    jPanel11Layout.setVerticalGroup(
        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel11Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titreRomanRech4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ISBNRomanRech4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(19, 19, 19)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editeurRomanRech4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(auteurRomanRech4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(16, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
    jPanel7.setLayout(jPanel7Layout);
    jPanel7Layout.setHorizontalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel7Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel7Layout.setVerticalGroup(
        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );

    jTabbedPane2.addTab("Livres ", jPanel7);

    jPanel13.setBackground(new java.awt.Color(255, 255, 255));

    jPanel14.setBackground(new java.awt.Color(255, 255, 255));
    jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste des Revus", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 12))); // NOI18N

    revusTable.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
    revusTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    ));
    revusTable.setRowHeight(30);
    revusTable.setSelectionBackground(new java.awt.Color(62, 64, 70));
    revusTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            revusTableMouseClicked(evt);
        }
    });
    jScrollPane3.setViewportView(revusTable);

    javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
    jPanel14.setLayout(jPanel14Layout);
    jPanel14Layout.setHorizontalGroup(
        jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel14Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane3)
            .addContainerGap())
    );
    jPanel14Layout.setVerticalGroup(
        jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel14Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
            .addContainerGap())
    );

    jPanel26.setBackground(new java.awt.Color(255, 255, 255));
    jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rechercher un  Revus", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 12))); // NOI18N

    jLabel42.setBackground(new java.awt.Color(0, 0, 0));
    jLabel42.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel42.setText("ISBN ");

    ISBNRomanRech2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ISBNRomanRech2ActionPerformed(evt);
        }
    });

    jLabel43.setBackground(new java.awt.Color(0, 0, 0));
    jLabel43.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel43.setText("Titre ");

    jLabel44.setBackground(new java.awt.Color(0, 0, 0));
    jLabel44.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel44.setText("Auteur ");

    jLabel45.setBackground(new java.awt.Color(0, 0, 0));
    jLabel45.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel45.setText("Editeur");

    javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
    jPanel26.setLayout(jPanel26Layout);
    jPanel26Layout.setHorizontalGroup(
        jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel26Layout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel26Layout.createSequentialGroup()
                    .addComponent(jLabel42)
                    .addGap(18, 18, 18)
                    .addComponent(ISBNRomanRech2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel26Layout.createSequentialGroup()
                    .addComponent(jLabel44)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(auteurRomanRech2)))
            .addGap(18, 18, 18)
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel26Layout.createSequentialGroup()
                    .addComponent(jLabel43)
                    .addGap(18, 18, 18)
                    .addComponent(titreRomanRech2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel26Layout.createSequentialGroup()
                    .addComponent(jLabel45)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(editeurRomanRech2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel26Layout.setVerticalGroup(
        jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel26Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(ISBNRomanRech2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(titreRomanRech2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(auteurRomanRech2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(editeurRomanRech2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
    jPanel13.setLayout(jPanel13Layout);
    jPanel13Layout.setHorizontalGroup(
        jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel13Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createSequentialGroup()
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addContainerGap())
    );
    jPanel13Layout.setVerticalGroup(
        jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel13Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );

    jTabbedPane2.addTab("Revus ", jPanel13);

    jPanel21.setBackground(new java.awt.Color(255, 255, 255));

    jPanel22.setBackground(new java.awt.Color(255, 255, 255));
    jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rechercher une Bande_Dessinee", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 12))); // NOI18N

    jLabel30.setBackground(new java.awt.Color(0, 0, 0));
    jLabel30.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel30.setText("ISBN ");

    jLabel31.setBackground(new java.awt.Color(0, 0, 0));
    jLabel31.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel31.setText("Auteur ");

    jLabel32.setBackground(new java.awt.Color(0, 0, 0));
    jLabel32.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel32.setText("Titre");

    jLabel33.setBackground(new java.awt.Color(0, 0, 0));
    jLabel33.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel33.setText("Editeur");

    javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
    jPanel22.setLayout(jPanel22Layout);
    jPanel22Layout.setHorizontalGroup(
        jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel22Layout.createSequentialGroup()
            .addGap(52, 52, 52)
            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel22Layout.createSequentialGroup()
                    .addComponent(jLabel31)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(bandeAuteurRech, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel33))
                .addGroup(jPanel22Layout.createSequentialGroup()
                    .addComponent(jLabel30)
                    .addGap(29, 29, 29)
                    .addComponent(bandeIsbnRech, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel32)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(bandeTitreRech, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addComponent(bandeEditeurRech))
            .addContainerGap(32, Short.MAX_VALUE))
    );
    jPanel22Layout.setVerticalGroup(
        jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel22Layout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(bandeIsbnRech, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(bandeTitreRech, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(20, 20, 20)
            .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bandeEditeurRech, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bandeAuteurRech, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jPanel23.setBackground(new java.awt.Color(255, 255, 255));
    jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste des Bandes_Dessinees", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 12))); // NOI18N

    bandesDTable.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
    bandesDTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    ));
    bandesDTable.setRowHeight(30);
    bandesDTable.setSelectionBackground(new java.awt.Color(62, 64, 70));
    bandesDTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            bandesDTableMouseClicked(evt);
        }
    });
    jScrollPane5.setViewportView(bandesDTable);

    javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
    jPanel23.setLayout(jPanel23Layout);
    jPanel23Layout.setHorizontalGroup(
        jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel23Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
            .addContainerGap())
    );
    jPanel23Layout.setVerticalGroup(
        jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel23Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
            .addContainerGap())
    );

    javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
    jPanel21.setLayout(jPanel21Layout);
    jPanel21Layout.setHorizontalGroup(
        jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel21Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );
    jPanel21Layout.setVerticalGroup(
        jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel21Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );

    javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
    jPanel16.setLayout(jPanel16Layout);
    jPanel16Layout.setHorizontalGroup(
        jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jPanel16Layout.setVerticalGroup(
        jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    jTabbedPane2.addTab("Bande_Dessinees", jPanel16);

    jPanel18.setBackground(new java.awt.Color(255, 255, 255));

    jPanel20.setBackground(new java.awt.Color(255, 255, 255));
    jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste des guides", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 12))); // NOI18N

    guidesTable.setFont(new java.awt.Font("Segoe Print", 1, 12)); // NOI18N
    guidesTable.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
        },
        new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
        }
    ));
    guidesTable.setRowHeight(30);
    guidesTable.setSelectionBackground(new java.awt.Color(62, 64, 70));
    guidesTable.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            guidesTableMouseClicked(evt);
        }
    });
    jScrollPane4.setViewportView(guidesTable);

    javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
    jPanel20.setLayout(jPanel20Layout);
    jPanel20Layout.setHorizontalGroup(
        jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel20Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane4)
            .addContainerGap())
    );
    jPanel20Layout.setVerticalGroup(
        jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel20Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
            .addContainerGap())
    );

    jPanel27.setBackground(new java.awt.Color(255, 255, 255));
    jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rechercher un  Guide_Voyage", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe Print", 1, 12))); // NOI18N

    jLabel46.setBackground(new java.awt.Color(0, 0, 0));
    jLabel46.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel46.setText("ISBN ");

    ISBNRomanRech3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ISBNRomanRech3ActionPerformed(evt);
        }
    });

    jLabel47.setBackground(new java.awt.Color(0, 0, 0));
    jLabel47.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel47.setText("Titre ");

    jLabel48.setBackground(new java.awt.Color(0, 0, 0));
    jLabel48.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel48.setText("Auteur ");

    jLabel49.setBackground(new java.awt.Color(0, 0, 0));
    jLabel49.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel49.setText("Editeur");

    javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
    jPanel27.setLayout(jPanel27Layout);
    jPanel27Layout.setHorizontalGroup(
        jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel27Layout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel27Layout.createSequentialGroup()
                    .addComponent(jLabel46)
                    .addGap(18, 18, 18)
                    .addComponent(ISBNRomanRech3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel27Layout.createSequentialGroup()
                    .addComponent(jLabel48)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(auteurRomanRech3)))
            .addGap(18, 18, 18)
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel27Layout.createSequentialGroup()
                    .addComponent(jLabel47)
                    .addGap(18, 18, 18)
                    .addComponent(titreRomanRech3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel27Layout.createSequentialGroup()
                    .addComponent(jLabel49)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(editeurRomanRech3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel27Layout.setVerticalGroup(
        jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel27Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(ISBNRomanRech3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(titreRomanRech3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(auteurRomanRech3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(editeurRomanRech3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
    jPanel18.setLayout(jPanel18Layout);
    jPanel18Layout.setHorizontalGroup(
        jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel18Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
    );
    jPanel18Layout.setVerticalGroup(
        jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel18Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())
    );

    javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
    jPanel17.setLayout(jPanel17Layout);
    jPanel17Layout.setHorizontalGroup(
        jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jPanel17Layout.setVerticalGroup(
        jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel17Layout.createSequentialGroup()
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );

    jTabbedPane2.addTab("Guide_voyage", jPanel17);

    jPanel4.add(jTabbedPane2);
    jTabbedPane2.setBounds(16, 25, 677, 518);

    jPanel1.add(jPanel4);
    jPanel4.setBounds(620, 2, 730, 570);

    getContentPane().add(jPanel1);
    jPanel1.setBounds(0, 130, 1410, 590);

    javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
    jPanel12.setLayout(jPanel12Layout);
    jPanel12Layout.setHorizontalGroup(
        jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 0, Short.MAX_VALUE)
    );
    jPanel12Layout.setVerticalGroup(
        jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 0, Short.MAX_VALUE)
    );

    getContentPane().add(jPanel12);
    jPanel12.setBounds(0, 0, 0, 0);

    jPanel5.setBackground(new java.awt.Color(62, 64, 70));

    jButton4.setBackground(new java.awt.Color(255, 255, 255));
    jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/pskch.png"))); // NOI18N
    jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jButton4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jButton4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton4ActionPerformed(evt);
        }
    });

    jButton5.setBackground(new java.awt.Color(255, 255, 255));
    jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/Files-Edit-File-icon.png"))); // NOI18N
    jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jButton5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jButton5.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton5ActionPerformed(evt);
        }
    });

    jButton6.setBackground(new java.awt.Color(255, 255, 255));
    jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/gggg.png"))); // NOI18N
    jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jButton6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jButton6.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton6ActionPerformed(evt);
        }
    });

    jButton14.setBackground(new java.awt.Color(255, 255, 255));
    jButton14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/papa.png"))); // NOI18N
    jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jButton14.setOpaque(false);
    jButton14.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jButton14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jButton14.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton14ActionPerformed(evt);
        }
    });

    jButton15.setBackground(new java.awt.Color(255, 255, 255));
    jButton15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
    jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/nn.jpg"))); // NOI18N
    jButton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
    jButton15.setOpaque(false);
    jButton15.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    jButton15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
    jButton15.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton15ActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel5Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(983, Short.MAX_VALUE))
    );
    jPanel5Layout.setVerticalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel5Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    getContentPane().add(jPanel5);
    jPanel5.setBounds(0, 50, 1400, 80);

    jPanel15.setBackground(new java.awt.Color(255, 255, 255));

    jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/users_group-512.png"))); // NOI18N
    jLabel1.setText("Gestion Abonnees ");
    jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabel1.setFocusCycleRoot(true);
    jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel1MouseClicked(evt);
        }
    });

    jLabel2.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/printed-matter-books-icon.png"))); // NOI18N
    jLabel2.setText("Gestion Ouvrages ");
    jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabel2.setFocusCycleRoot(true);

    jLabel3.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/grey_new_seo-26-512.png"))); // NOI18N
    jLabel3.setText("Gestion Assistants ");
    jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel3MouseClicked(evt);
        }
    });

    jLabel22.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/borrow_book_256.png"))); // NOI18N
    jLabel22.setText("Gestion Empruntes  ");
    jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel22MouseClicked(evt);
        }
    });

    jLabel24.setFont(new java.awt.Font("Segoe Print", 1, 14)); // NOI18N
    jLabel24.setForeground(new java.awt.Color(255, 0, 0));
    jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/design/exit.png"))); // NOI18N
    jLabel24.setText("Deconnexion ");
    jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel24MouseClicked(evt);
        }
    });

    javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
    jPanel15.setLayout(jPanel15Layout);
    jPanel15Layout.setHorizontalGroup(
        jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel15Layout.createSequentialGroup()
            .addGap(125, 125, 125)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel22)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel3)
            .addGap(151, 151, 151)
            .addComponent(jLabel24)
            .addContainerGap(227, Short.MAX_VALUE))
    );
    jPanel15Layout.setVerticalGroup(
        jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel24))
    );

    getContentPane().add(jPanel15);
    jPanel15.setBounds(0, 0, 1400, 50);

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        Ouvrage ouvrage = getParam();
        String typeOuvrage = typeOuvrageCombobox.getSelectedItem().toString();

        if (typeOuvrage.equals("Roman")) {

            Roman roman = new Roman();
            roman.setId(ouvrage.getId());
            roman.setTitre(ouvrage.getTitre());
            roman.setAuteur(ouvrage.getAuteur());
            roman.setEditeur(ouvrage.getEditeur());
            roman.setDateEdition(ouvrage.getDateEdition());
            roman.setQuantiteStock(ouvrage.getQuantiteStock());
            roman.setCouverture(ouvrage.getCouverture());

            try {
                if (roman != null) {
                    int res = romanService.ajouterRoman(roman);
                    if (res == 1) {
                        romanHelper.save(roman);
                        JOptionPane.showMessageDialog(null, "Roman bien Ajouter ");
                    } else {
                        //JOptionPane.showMessageDialog(null, "ISBN deja existe");
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ISBN deja existe ");
            }

        } else if (typeOuvrage.equals("Livre")) {

            Livre livre = new Livre();
            livre.setId(ouvrage.getId());
            livre.setTitre(ouvrage.getTitre());
            livre.setAuteur(ouvrage.getAuteur());
            livre.setEditeur(ouvrage.getEditeur());
            livre.setDateEdition(ouvrage.getDateEdition());
            livre.setQuantiteStock(ouvrage.getQuantiteStock());
            livre.setCouverture(ouvrage.getCouverture());

            try {
                if (livre != null) {
                    int res = livreService.ajouterLivre(livre);
                    if (res == 1) {
                        livreHelper.save(livre);
                        JOptionPane.showMessageDialog(null, "Livre bien Ajouter ");
                    }
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ISBN deja existe ");
                Logger.getLogger(OuvragesView.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (typeOuvrage.equals("Revus")) {

            Revus revus = new Revus();

            revus.setId(ouvrage.getId());
            revus.setTitre(ouvrage.getTitre());
            revus.setAuteur(ouvrage.getAuteur());
            revus.setEditeur(ouvrage.getEditeur());
            revus.setDateEdition(ouvrage.getDateEdition());
            revus.setQuantiteStock(ouvrage.getQuantiteStock());
            revus.setCouverture(ouvrage.getCouverture());

            try {
                if (revus != null) {
                    int res = revusService.ajouterRevus(revus);
                    if (res == 1) {
                        revusHelper.save(revus);
                        JOptionPane.showMessageDialog(null, "Revus bien Ajouter ");
                    }
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ISBN deja existe ");
                Logger.getLogger(OuvragesView.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (typeOuvrage.equals("Bande dessinee")) {

            BandeDessine bandeDessine = new BandeDessine();

            bandeDessine.setId(ouvrage.getId());
            bandeDessine.setTitre(ouvrage.getTitre());
            bandeDessine.setAuteur(ouvrage.getAuteur());
            bandeDessine.setEditeur(ouvrage.getEditeur());
            bandeDessine.setDateEdition(ouvrage.getDateEdition());
            bandeDessine.setQuantiteStock(ouvrage.getQuantiteStock());
            bandeDessine.setCouverture(ouvrage.getCouverture());
            //
            bandeDessine.setCollection(collection.getText());
            bandeDessine.setCouleur(couleur.getText());
            bandeDessine.setScenaroi(scenario.getText());
            bandeDessine.setDessin(dessin.getText());

            try {
                if (bandeDessine != null) {
                    int res = bandesDService.ajouterBande(bandeDessine);
                    if (res == 1) {
                        bandeDHelper.save(bandeDessine);
                        JOptionPane.showMessageDialog(null, "Bande Dessinee bien Ajouter ");
                    }
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ISBN deja existe ");
                Logger.getLogger(OuvragesView.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (typeOuvrage.equals("Guide de voyage")) {

            GuideVoyage guideVoyage = new GuideVoyage();

            guideVoyage.setId(ouvrage.getId());
            guideVoyage.setTitre(ouvrage.getTitre());
            guideVoyage.setAuteur(ouvrage.getAuteur());
            guideVoyage.setEditeur(ouvrage.getEditeur());
            guideVoyage.setDateEdition(ouvrage.getDateEdition());
            guideVoyage.setQuantiteStock(ouvrage.getQuantiteStock());
            guideVoyage.setCouverture(ouvrage.getCouverture());

            try {
                if (guideVoyage != null) {
                    int res = guideService.ajouterGuide(guideVoyage);
                    if (res == 1) {
                        guideHelper.save(guideVoyage);
                        JOptionPane.showMessageDialog(null, "Guide_voyage  bien Ajouter ");
                    }
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "ISBN deja existe ");
                Logger.getLogger(OuvragesView.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {

            if (jTabbedPane2.getSelectedIndex() == 0) {
                if (romanHelper.getSelected() != null) {

                    Roman romanToModify = new Roman();

                    romanToModify.setId(getParamMod().getId());
                    romanToModify.setTitre(getParamMod().getTitre());
                    romanToModify.setAuteur(getParamMod().getAuteur());
                    romanToModify.setEditeur(getParamMod().getEditeur());
                    romanToModify.setDateEdition(getParamMod().getDateEdition());
                    romanToModify.setCouverture(getParamMod().getCouverture());
                    romanToModify.setQuantiteStock(getParamMod().getQuantiteStock());
                    romanToModify.setCouverture(romanHelper.getSelected().getCouverture());

                    int p = JOptionPane.showConfirmDialog(null, "Vous Voulez Vraiment Modifier Ce Roman ??", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (p == 0) {
                        int res = romanService.modifierRoman(romanToModify);

                        if (res == 1) {
                            JOptionPane.showMessageDialog(null, "Roman bien modifier ");
                            romanHelper.update(romanToModify);
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Priere de selectionez l'ouvrage a Modifier ", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (jTabbedPane2.getSelectedIndex() == 1) {

                if (livreHelper.getSelected() != null) {

                    Livre livreToModify = new Livre();

                    livreToModify.setId(getParamMod().getId());
                    livreToModify.setTitre(getParamMod().getTitre());
                    livreToModify.setAuteur(getParamMod().getAuteur());
                    livreToModify.setEditeur(getParamMod().getEditeur());
                    livreToModify.setDateEdition(getParamMod().getDateEdition());
                    livreToModify.setCouverture(getParamMod().getCouverture());
                    livreToModify.setQuantiteStock(getParamMod().getQuantiteStock());
                    livreToModify.setCouverture(livreHelper.getSelected().getCouverture());

                    int p = JOptionPane.showConfirmDialog(null, "Vous Voulez Vraiment Modifier Ce Livre ??", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (p == 0) {
                        int res = livreService.modifierLivre(livreToModify);

                        if (res == 1) {
                            JOptionPane.showMessageDialog(null, "Roman bien modifier ");
                            livreHelper.update(livreToModify);
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Priere de selectionez l'ouvrage a Modifier ", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (jTabbedPane2.getSelectedIndex() == 2) {

                if (revusHelper.getSelected() != null) {

                    Revus revusToModify = new Revus();

                    revusToModify.setId(getParamMod().getId());
                    revusToModify.setTitre(getParamMod().getTitre());
                    revusToModify.setAuteur(getParamMod().getAuteur());
                    revusToModify.setEditeur(getParamMod().getEditeur());
                    revusToModify.setDateEdition(getParamMod().getDateEdition());
                    revusToModify.setCouverture(getParamMod().getCouverture());
                    revusToModify.setQuantiteStock(getParamMod().getQuantiteStock());
                    revusToModify.setCouverture(revusHelper.getSelected().getCouverture());

                    int p = JOptionPane.showConfirmDialog(null, "Vous Voulez Vraiment Modifier Ce Revus ??", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (p == 0) {
                        int res = revusService.modifierRevus(revusToModify);

                        if (res == 1) {
                            JOptionPane.showMessageDialog(null, "Revus bien modifier ");
                            revusHelper.update(revusToModify);
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Priere de selectionez l'ouvrage a Modifier ", "Info", JOptionPane.INFORMATION_MESSAGE);
                }

            } else if (jTabbedPane2.getSelectedIndex() == 3) {

                if (bandeDHelper.getSelected() != null) {

                    BandeDessine bandeToModify = new BandeDessine();

                    bandeToModify.setId(getParamMod().getId());
                    bandeToModify.setTitre(getParamMod().getTitre());
                    bandeToModify.setAuteur(getParamMod().getAuteur());
                    bandeToModify.setEditeur(getParamMod().getEditeur());
                    bandeToModify.setDateEdition(getParamMod().getDateEdition());
                    bandeToModify.setCouverture(getParamMod().getCouverture());
                    bandeToModify.setQuantiteStock(getParamMod().getQuantiteStock());
                    bandeToModify.setCouverture(bandeDHelper.getSelected().getCouverture());

                    int p = JOptionPane.showConfirmDialog(null, "Vous Voulez Vraiment Modifier Ce Bande Dessinee ??", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (p == 0) {
                        int res = bandesDService.modifierBandeD(bandeToModify);

                        if (res == 1) {
                            JOptionPane.showMessageDialog(null, "Bande Dessinee bien modifier ");
                            bandeDHelper.update(bandeToModify);
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Priere de selectionez l'ouvrage a Modifier ", "Info", JOptionPane.INFORMATION_MESSAGE);
                }

            } else if (jTabbedPane2.getSelectedIndex() == 4) {
                if (guideHelper.getSelected() != null) {

                    GuideVoyage guideToModify = new GuideVoyage();

                    guideToModify.setId(getParamMod().getId());
                    guideToModify.setTitre(getParamMod().getTitre());
                    guideToModify.setAuteur(getParamMod().getAuteur());
                    guideToModify.setEditeur(getParamMod().getEditeur());
                    guideToModify.setDateEdition(getParamMod().getDateEdition());
                    guideToModify.setCouverture(getParamMod().getCouverture());
                    guideToModify.setQuantiteStock(getParamMod().getQuantiteStock());
                    guideToModify.setCouverture(guideHelper.getSelected().getCouverture());

                    int p = JOptionPane.showConfirmDialog(null, "Vous Voulez Vraiment Modifier Ce Guide ??", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (p == 0) {
                        int res = guideService.modifierGuide(guideToModify);

                        if (res == 1) {
                            JOptionPane.showMessageDialog(null, "Guide  bien modifier ");
                            guideHelper.update(guideToModify);
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Priere de selectionez l'ouvrage a Modifier ", "Info", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        } catch (Exception ex) {
        }


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        try {
            //ici je detecte qu-il s'agit d'un  Roman  
            if (jTabbedPane2.getSelectedIndex() == 0) {

                if (romanHelper.getSelected() != null) {
                    int response = JOptionPane.showConfirmDialog(null, "Vous Voulez Vraiment Supprimer Ce Roman ??", "Confirm", JOptionPane.YES_NO_OPTION);
                    // s'il y ait une confimation
                    if (response == 0) {
                        int res = romanService.supprimerRoman(romanHelper.getSelected());
                        if (res > 0) {
                            JOptionPane.showMessageDialog(null, "Roman Bien Supprimer ", "Info", JOptionPane.INFORMATION_MESSAGE);
                            romanHelper.remove(romanHelper.getSelected());
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Priere de selectionez l'ouvrage a supprimer ", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (jTabbedPane2.getSelectedIndex() == 1) {

                if (livreHelper.getSelected() != null) {

                    int response = JOptionPane.showConfirmDialog(null, "Vous Voulez Vraiment Supprimer Ce Livre ??", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (response == 0) {
                        int res = livreService.supprimerLivre(livreHelper.getSelected());
                        if (res > 0) {
                            JOptionPane.showMessageDialog(null, "Livre Bien Supprimer ", "Info", JOptionPane.INFORMATION_MESSAGE);
                            livreHelper.remove(livreHelper.getSelected());
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Priere de selectionez l'ouvrage a supprimer ", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (jTabbedPane2.getSelectedIndex() == 2) {

                if (revusHelper.getSelected() != null) {
                    int response = JOptionPane.showConfirmDialog(null, "Vous Voulez Vraiment Supprimer Ce Revus ??", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (response == 0) {
                        int res = revusService.supprimerRevus(revusHelper.getSelected());
                        if (res > 0) {
                            JOptionPane.showMessageDialog(null, "Revus Bien Supprimer ", "Info", JOptionPane.INFORMATION_MESSAGE);
                            revusHelper.remove(revusHelper.getSelected());
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Priere de selectionez l'ouvrage a supprimer ", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (jTabbedPane2.getSelectedIndex() == 3) {
                if (bandeDHelper.getSelected() != null) {
                    int response = JOptionPane.showConfirmDialog(null, "Vous Voulez Vraiment Supprimer Ce Bande Desinee ??", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (response == 0) {
                        int res = bandesDService.supprimerBande(bandeDHelper.getSelected());
                        if (res > 0) {
                            JOptionPane.showMessageDialog(null, "Bande Desinee Bien Supprimer ", "Info", JOptionPane.INFORMATION_MESSAGE);
                            bandeDHelper.remove(bandeDHelper.getSelected());
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Priere de selectionez l'ouvrage a supprimer ", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (jTabbedPane2.getSelectedIndex() == 4) {
                if (guideHelper.getSelected() != null) {
                    int response = JOptionPane.showConfirmDialog(null, "Vous Voulez Vraiment Supprimer Ce Guide ??", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (response == 0) {
                        int res = guideService.supprimerGuide(guideHelper.getSelected());
                        if (res > 0) {
                            JOptionPane.showMessageDialog(null, "Guide  Bien Supprimer ", "Info", JOptionPane.INFORMATION_MESSAGE);
                            guideHelper.remove(guideHelper.getSelected());
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Priere de selectionez l'ouvrage a supprimer ", "Info", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        try {
            if (jTabbedPane2.getSelectedIndex() == 0) {

                List<Roman> romans = romanService.rechercheRomans(ISBNRomanRech.getText(), titreRomanRech.getText(), auteurRomanRech.getText(), editeurRomanRech.getText());
                romanHelper.setList(romans);
            } else if (jTabbedPane2.getSelectedIndex() == 1) {

                List<Livre> livres = livreService.rechercheLivres(ISBNRomanRech4.getText(), titreRomanRech4.getText(), auteurRomanRech4.getText(), editeurRomanRech4.getText());
                livreHelper.setList(livres);
            } else if (jTabbedPane2.getSelectedIndex() == 2) {

                List<Revus> revus = revusService.rechercheRevus(ISBNRomanRech2.getText(), titreRomanRech2.getText(), auteurRomanRech2.getText(), editeurRomanRech2.getText());
                revusHelper.setList(revus);
            } else if (jTabbedPane2.getSelectedIndex() == 3) {

                List<BandeDessine> bandes = bandesDService.rechercheBandes(bandeIsbnRech.getText(), bandeTitreRech.getText(), bandeAuteurRech.getText(), bandeEditeurRech.getText());
                bandeDHelper.setList(bandes);
            } else if (jTabbedPane2.getSelectedIndex() == 4) {

                List<GuideVoyage> guides = guideService.rechercheGuides(ISBNRomanRech3.getText(), titreRomanRech3.getText(), auteurRomanRech3.getText(), editeurRomanRech3.getText());
                guideHelper.setList(guides);
            }
        } catch (Exception ex) {
            Logger.getLogger(OuvragesView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        try {
            cleanView();
        } catch (Exception ex) {
            Logger.getLogger(OuvragesView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void typeOuvrageComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeOuvrageComboboxActionPerformed
        // TODO add your handling code here:

        if (typeOuvrageCombobox.getSelectedItem() == "Bande dessinee") {
            panelInfoSupLivre.setVisible(true);
        } else {
            panelInfoSupLivre.setVisible(false);

        }
    }//GEN-LAST:event_typeOuvrageComboboxActionPerformed

    private void parcourirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parcourirActionPerformed
        //pour l'upload d'une image 

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "png", "gif");
        chooser.addChoosableFileFilter(filter);
        int result = chooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            imageLabel.setIcon(ResizeImage(path));
            System.out.println(path);
        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("no data");
        }
    }//GEN-LAST:event_parcourirActionPerformed

    private void typeOuvrageComboboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_typeOuvrageComboboxItemStateChanged


    }//GEN-LAST:event_typeOuvrageComboboxItemStateChanged

    private void guidesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guidesTableMouseClicked
        // TODO add your handling code here:
        GuideVoyage guideVoyage = guideHelper.getSelected();

        isbnTextField.setText(guideVoyage.getId());
        titreTextField.setText(guideVoyage.getTitre());
        auteurTextField.setText(guideVoyage.getAuteur());
        editeurTextField.setText(guideVoyage.getEditeur());
        quantiteTextField.setText(guideVoyage.getQuantiteStock() + "");
        typeOuvrageCombobox.setSelectedItem("Guide de voyage");
        //dateEditionSchooser.setD(roman.getDateEdition());
        imageLabel.setIcon(ResizeImage(guideVoyage.getCouverture()));
    }//GEN-LAST:event_guidesTableMouseClicked

    private void bandesDTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bandesDTableMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        BandeDessine bandeDessine = bandeDHelper.getSelected();

        isbnTextField.setText(bandeDessine.getId());
        titreTextField.setText(bandeDessine.getTitre());
        auteurTextField.setText(bandeDessine.getAuteur());
        editeurTextField.setText(bandeDessine.getEditeur());
        quantiteTextField.setText(bandeDessine.getQuantiteStock() + "");
        typeOuvrageCombobox.setSelectedItem("Bande dessinee");
        //dateEditionSchooser.setD(roman.getDateEdition());
        imageLabel.setIcon(ResizeImage(bandeDessine.getCouverture()));
    }//GEN-LAST:event_bandesDTableMouseClicked

    private void revusTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_revusTableMouseClicked
        // TODO add your handling code here:
        Revus revus = revusHelper.getSelected();

        isbnTextField.setText(revus.getId());
        titreTextField.setText(revus.getTitre());
        auteurTextField.setText(revus.getAuteur());
        editeurTextField.setText(revus.getEditeur());
        quantiteTextField.setText(revus.getQuantiteStock() + "");
        typeOuvrageCombobox.setSelectedItem("Revus");
        //dateEditionSchooser.setD(roman.getDateEdition());
        imageLabel.setIcon(ResizeImage(revus.getCouverture()));
    }//GEN-LAST:event_revusTableMouseClicked

    private void auteurRomanRech4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_auteurRomanRech4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_auteurRomanRech4ActionPerformed

    private void tableLivresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLivresMouseClicked
        // TODO add your handling code here:

        Livre livre = livreHelper.getSelected();

        isbnTextField.setText(livre.getId());
        titreTextField.setText(livre.getTitre());
        auteurTextField.setText(livre.getAuteur());
        editeurTextField.setText(livre.getEditeur());
        quantiteTextField.setText(livre.getQuantiteStock() + "");
        typeOuvrageCombobox.setSelectedItem("Livre");
        //dateEditionSchooser.setD(roman.getDateEdition());
        imageLabel.setIcon(ResizeImage(livre.getCouverture()));
    }//GEN-LAST:event_tableLivresMouseClicked

    private void tableRomansMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRomansMouseClicked
        // TODO add your handling code here:

        Roman roman = romanHelper.getSelected();

        isbnTextField.setText(roman.getId());
        titreTextField.setText(roman.getTitre());
        auteurTextField.setText(roman.getAuteur());
        editeurTextField.setText(roman.getEditeur());
        quantiteTextField.setText(roman.getQuantiteStock() + "");
        typeOuvrageCombobox.setSelectedItem("Roman");
        //dateEditionSchooser.setD(roman.getDateEdition());
        imageLabel.setIcon(ResizeImage(roman.getCouverture()));
    }//GEN-LAST:event_tableRomansMouseClicked

    private void ISBNRomanRechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBNRomanRechActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISBNRomanRechActionPerformed

    private void ISBNRomanRech2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBNRomanRech2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISBNRomanRech2ActionPerformed

    private void ISBNRomanRech3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISBNRomanRech3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISBNRomanRech3ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

        AbonnemetView av = new AbonnemetView();
        av.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

        AssistantsView av = new AssistantsView();
        av.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        // TODO add your handling code here:
        PretView pv = new PretView();
        pv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        // TODO add your handling code here:
        ConnexionViews cv = new ConnexionViews();
        cv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel24MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OuvragesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OuvragesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OuvragesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OuvragesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OuvragesView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ISBNRomanRech;
    private javax.swing.JTextField ISBNRomanRech2;
    private javax.swing.JTextField ISBNRomanRech3;
    private javax.swing.JTextField ISBNRomanRech4;
    private javax.swing.JTextField auteurRomanRech;
    private javax.swing.JTextField auteurRomanRech2;
    private javax.swing.JTextField auteurRomanRech3;
    private javax.swing.JTextField auteurRomanRech4;
    private javax.swing.JTextField auteurTextField;
    private javax.swing.JTextField bandeAuteurRech;
    private javax.swing.JTextField bandeEditeurRech;
    private javax.swing.JTextField bandeIsbnRech;
    private javax.swing.JTextField bandeTitreRech;
    private javax.swing.JTable bandesDTable;
    private javax.swing.JTextField collection;
    private javax.swing.JTextField couleur;
    private datechooser.beans.DateChooserCombo dateEditionSchooser;
    private javax.swing.JTextField dessin;
    private javax.swing.JTextField editeurRomanRech;
    private javax.swing.JTextField editeurRomanRech2;
    private javax.swing.JTextField editeurRomanRech3;
    private javax.swing.JTextField editeurRomanRech4;
    private javax.swing.JTextField editeurTextField;
    private javax.swing.JTable guidesTable;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JTextField isbnTextField;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel panelInfoSupLivre;
    private javax.swing.JButton parcourir;
    private javax.swing.JTextField quantiteTextField;
    private javax.swing.JTable revusTable;
    private javax.swing.JTextField scenario;
    private javax.swing.JTable tableLivres;
    private javax.swing.JTable tableRomans;
    private javax.swing.JTextField titreRomanRech;
    private javax.swing.JTextField titreRomanRech2;
    private javax.swing.JTextField titreRomanRech3;
    private javax.swing.JTextField titreRomanRech4;
    private javax.swing.JTextField titreTextField;
    private javax.swing.JComboBox<String> typeOuvrageCombobox;
    // End of variables declaration//GEN-END:variables
}
