/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package my.blocktreasurehunt;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

/**
 *
 * @author Kiana M. Yeo
 * @date February 25, 2026
 */
public class BlockTreasureHuntUI extends javax.swing.JFrame {

    // =========================================================
    // GAME VARIABLES
    // =========================================================

    private int[][] symbols = new int[4][4];

    /*
     * symbols:
     *
     * 0 = Treasure
     * 1 = TNT
     * 2 = Dirt
     * 3 = Stone
     */

    private int treasureCount = 0;

    private boolean gameOver = false;

    // =========================================================
    // COLORS
    // =========================================================

    private final Color BACKGROUND =
            new Color(255, 248, 231);

    private final Color DARK_BROWN =
            new Color(78, 52, 46);

    private final Color GREEN =
            new Color(56, 106, 50);

    private final Color BOARD_BROWN =
            new Color(121, 85, 72);

    private final Color BUTTON_GREEN =
            new Color(165, 214, 106);

    private final Color TEAL =
            new Color(37, 125, 120);

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public BlockTreasureHuntUI() {

        initComponents();

        initSymbols();

        setupGameUI();

        setTitle("⛏ Block Treasure Hunt");

        setSize(700, 800);

        setLocationRelativeTo(null);

        setResizable(false);
    }

    // =========================================================
    // CREATE / RANDOMIZE GAME BOARD
    // =========================================================

    private void initSymbols() {

        // Clear the entire board first
        for (int row = 0; row < 4; row++) {

            for (int col = 0; col < 4; col++) {

                symbols[row][col] = 0;
            }
        }

        /*
         * We need exactly 3 danger blocks.
         *
         * 16 total blocks
         * - 3 danger blocks
         * = 13 treasure blocks
         */

        int dangerPlaced = 0;

        while (dangerPlaced < 3) {

            int row =
                    (int) (Math.random() * 4);

            int col =
                    (int) (Math.random() * 4);

            // Only place danger on an empty space
            if (symbols[row][col] == 0) {

                /*
                 * Randomly choose:
                 *
                 * 1 = TNT
                 * 2 = Dirt
                 * 3 = Stone
                 */

                symbols[row][col] =
                        1 + (int) (Math.random() * 3);

                dangerPlaced++;
            }
        }
    }

    // =========================================================
    // SETUP GAME UI
    // =========================================================

    private void setupGameUI() {

        // =====================================================
        // MAIN PANEL
        // =====================================================

        JPanel mainPanel =
                new JPanel(
                        new BorderLayout(15, 15)
                );

        mainPanel.setBackground(BACKGROUND);

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        25,
                        30,
                        25,
                        30
                )
        );

        // =====================================================
        // HEADER
        // =====================================================

        JPanel customHeaderPanel =
                new JPanel(
                        new BorderLayout(5, 5)
                );

        customHeaderPanel.setBackground(
                BACKGROUND
        );

        // -----------------------------------------------------
        // TITLE
        // -----------------------------------------------------

        titleLabel.setText(
                "⛏ BLOCK TREASURE HUNT ⛏"
        );

        titleLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        titleLabel.setFont(
                new Font(
                        "Monospaced",
                        Font.BOLD,
                        30
                )
        );

        titleLabel.setForeground(GREEN);

        // -----------------------------------------------------
        // SUBTITLE
        // -----------------------------------------------------

        subtitleLabel.setText(
                "Find the treasures. Avoid the danger blocks!"
        );

        subtitleLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        subtitleLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        16
                )
        );

        subtitleLabel.setForeground(
                DARK_BROWN
        );

        // -----------------------------------------------------
        // TREASURE COUNTER
        // -----------------------------------------------------

        treasureLabel.setText(
                "💎 TREASURES: 0 / 13"
        );

        treasureLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        treasureLabel.setFont(
                new Font(
                        "Monospaced",
                        Font.BOLD,
                        18
                )
        );

        treasureLabel.setForeground(TEAL);

        // -----------------------------------------------------
        // HEADER CONTAINER
        // -----------------------------------------------------

        JPanel titleContainer =
                new JPanel(
                        new BorderLayout(5, 5)
                );

        titleContainer.setBackground(
                BACKGROUND
        );

        titleContainer.add(
                titleLabel,
                BorderLayout.NORTH
        );

        titleContainer.add(
                subtitleLabel,
                BorderLayout.CENTER
        );

        titleContainer.add(
                treasureLabel,
                BorderLayout.SOUTH
        );

        customHeaderPanel.add(
                titleContainer,
                BorderLayout.CENTER
        );

        // =====================================================
        // GAME BOARD
        // =====================================================

        boardPanel.setLayout(
                new GridLayout(
                        4,
                        4,
                        8,
                        8
                )
        );

        boardPanel.setBackground(
                BOARD_BROWN
        );

        boardPanel.setBorder(
                BorderFactory.createCompoundBorder(

                        BorderFactory.createLineBorder(
                                DARK_BROWN,
                                3
                        ),

                        BorderFactory.createEmptyBorder(
                                10,
                                10,
                                10,
                                10
                        )
                )
        );

        // =====================================================
        // GAME BUTTONS
        // =====================================================

        JButton[] buttons = {

            jButton1,
            jButton2,
            jButton3,
            jButton4,

            jButton5,
            jButton6,
            jButton7,
            jButton8,

            jButton9,
            jButton10,
            jButton11,
            jButton12,

            jButton13,
            jButton14,
            jButton15,
            jButton16
        };

        // =====================================================
        // STYLE EACH BUTTON
        // =====================================================

        for (JButton button : buttons) {

            styleGameButton(button);
        }

        /*
         * IMPORTANT:
         *
         * Each button is now connected to a specific
         * row and column on the symbols[][] board.
         */

        jButton1.addActionListener(
                e -> clicked(0, 0, jButton1)
        );

        jButton2.addActionListener(
                e -> clicked(0, 1, jButton2)
        );

        jButton3.addActionListener(
                e -> clicked(0, 2, jButton3)
        );

        jButton4.addActionListener(
                e -> clicked(0, 3, jButton4)
        );

        jButton5.addActionListener(
                e -> clicked(1, 0, jButton5)
        );

        jButton6.addActionListener(
                e -> clicked(1, 1, jButton6)
        );

        jButton7.addActionListener(
                e -> clicked(1, 2, jButton7)
        );

        jButton8.addActionListener(
                e -> clicked(1, 3, jButton8)
        );

        jButton9.addActionListener(
                e -> clicked(2, 0, jButton9)
        );

        jButton10.addActionListener(
                e -> clicked(2, 1, jButton10)
        );

        jButton11.addActionListener(
                e -> clicked(2, 2, jButton11)
        );

        jButton12.addActionListener(
                e -> clicked(2, 3, jButton12)
        );

        jButton13.addActionListener(
                e -> clicked(3, 0, jButton13)
        );

        jButton14.addActionListener(
                e -> clicked(3, 1, jButton14)
        );

        jButton15.addActionListener(
                e -> clicked(3, 2, jButton15)
        );

        jButton16.addActionListener(
                e -> clicked(3, 3, jButton16)
        );

        // =====================================================
        // ADD BUTTONS TO BOARD
        // =====================================================

        for (JButton button : buttons) {

            boardPanel.add(button);
        }

        // =====================================================
        // STATUS LABEL
        // =====================================================

        statusLabel.setText(
                "⛏ Dig carefully! Good luck!"
        );

        statusLabel.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        statusLabel.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        16
                )
        );

        statusLabel.setForeground(
                DARK_BROWN
        );

        // =====================================================
        // NEW GAME BUTTON
        // =====================================================

        jButton17.setText(
                "↻ NEW GAME"
        );

        jButton17.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        16
                )
        );

        jButton17.setForeground(
                Color.WHITE
        );

        jButton17.setBackground(
                GREEN
        );

        jButton17.setFocusPainted(false);

        jButton17.setBorder(
                BorderFactory.createEmptyBorder(
                        10,
                        25,
                        10,
                        25
                )
        );

        // Remove any old generated listeners
        for (
                java.awt.event.ActionListener listener
                : jButton17.getActionListeners()
        ) {

            jButton17.removeActionListener(listener);
        }

        // Add our actual New Game action
        jButton17.addActionListener(
                e -> resetGame()
        );

        // =====================================================
        // CREATOR LABEL
        // =====================================================

        jLabel1.setText(
                "made by kiacodesss"
        );

        jLabel1.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        jLabel1.setFont(
                new Font(
                        "Monospaced",
                        Font.BOLD,
                        12
                )
        );

        jLabel1.setForeground(GREEN);

        // =====================================================
        // BOTTOM PANEL
        // =====================================================

        bottomPanel.setLayout(
                new BorderLayout(5, 10)
        );

        bottomPanel.setBackground(
                BACKGROUND
        );

        bottomPanel.add(
                statusLabel,
                BorderLayout.NORTH
        );

        bottomPanel.add(
                jButton17,
                BorderLayout.CENTER
        );

        bottomPanel.add(
                jLabel1,
                BorderLayout.SOUTH
        );

        // =====================================================
        // ASSEMBLE UI
        // =====================================================

        mainPanel.add(
                customHeaderPanel,
                BorderLayout.NORTH
        );

        mainPanel.add(
                boardPanel,
                BorderLayout.CENTER
        );

        mainPanel.add(
                bottomPanel,
                BorderLayout.SOUTH
        );

        // =====================================================
        // REPLACE ORIGINAL GUI BUILDER CONTENT
        // =====================================================

        getContentPane().removeAll();

        getContentPane().setLayout(
                new BorderLayout()
        );

        getContentPane().add(
                mainPanel,
                BorderLayout.CENTER
        );

        getContentPane().revalidate();

        getContentPane().repaint();
    }

    // =========================================================
    // STYLE GAME BUTTON
    // =========================================================

    private void styleGameButton(
            JButton button
    ) {

        button.setText("");

        button.setIcon(null);

        button.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        18
                )
        );

        button.setBackground(
                BUTTON_GREEN
        );

        button.setForeground(
                DARK_BROWN
        );

        button.setFocusPainted(false);

        button.setOpaque(true);

        button.setBorder(
                BorderFactory.createLineBorder(
                        new Color(
                                104,
                                145,
                                67
                        ),
                        2
                )
        );

        button.setMargin(
                new Insets(
                        5,
                        5,
                        5,
                        5
                )
        );

        button.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        button.setVerticalAlignment(
                SwingConstants.CENTER
        );
    }

    // =========================================================
    // BUTTON CLICK LOGIC
    // =========================================================

    private void clicked(
            int row,
            int col,
            JButton button
    ) {

        // -----------------------------------------------------
        // SAFETY CHECK
        // -----------------------------------------------------

        if (gameOver) {

            return;
        }

        if (!button.isEnabled()) {

            return;
        }

        // -----------------------------------------------------
        // CHECK WHAT IS UNDER THE BLOCK
        // -----------------------------------------------------

        int blockType =
                symbols[row][col];

        String imagePath;

        // =====================================================
        // DANGER BLOCK
        // =====================================================

        if (blockType != 0) {

            // -------------------------------------------------
            // TNT
            // -------------------------------------------------

            if (blockType == 1) {

                imagePath =
                        "/resources/tnt.png";
            }

            // -------------------------------------------------
            // DIRT
            // -------------------------------------------------

            else if (blockType == 2) {

                imagePath =
                        "/resources/dirt.png";
            }

            // -------------------------------------------------
            // STONE
            // -------------------------------------------------

            else {

                imagePath =
                        "/resources/stone.png";
            }

            // -------------------------------------------------
            // REVEAL DANGER
            // -------------------------------------------------

            boolean imageShown =
                    showImage(
                            button,
                            imagePath
                    );

            // Even if image is missing,
            // the game should still end.
            gameOver = true;

            statusLabel.setText(
                    "💥 BOOM! You found a danger block!"
            );

            // Disable every remaining button
            disableBoard();

            JOptionPane.showMessageDialog(
                    this,

                    "💥 OH NO!\n\n"
                    + "You uncovered a dangerous block!\n"
                    + "Better luck next time!",

                    "GAME OVER",

                    JOptionPane.INFORMATION_MESSAGE
            );

            return;
        }

        // =====================================================
        // TREASURE
        // =====================================================

        treasureCount++;

        // -----------------------------------------------------
        // RANDOM TREASURE
        // -----------------------------------------------------

        int treasureType =
                (int) (Math.random() * 3);

        if (treasureType == 0) {

            imagePath =
                    "/resources/diamond.png";
        }

        else if (treasureType == 1) {

            imagePath =
                    "/resources/gold.png";
        }

        else {

            imagePath =
                    "/resources/emerald.png";
        }

        // -----------------------------------------------------
        // REVEAL TREASURE
        // -----------------------------------------------------

        showImage(
                button,
                imagePath
        );

        // -----------------------------------------------------
        // UPDATE COUNTER
        // -----------------------------------------------------

        treasureLabel.setText(
                "💎 TREASURES: "
                + treasureCount
                + " / 13"
        );

        // -----------------------------------------------------
        // UPDATE STATUS
        // -----------------------------------------------------

        statusLabel.setText(
                "✨ Treasure found! Keep digging!"
        );

        // =====================================================
        // WIN CONDITION
        // =====================================================

        if (treasureCount == 13) {

            gameOver = true;

            statusLabel.setText(
                    "🏆 ALL TREASURES FOUND!"
            );

            disableBoard();

            JOptionPane.showMessageDialog(
                    this,

                    "🏆 CONGRATULATIONS! 🏆\n\n"
                    + "You found all 13 treasures!\n"
                    + "You are a master treasure hunter!",

                    "YOU WIN!",

                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // =========================================================
    // SHOW IMAGE
    // =========================================================

    private boolean showImage(
            JButton button,
            String imagePath
    ) {

        /*
         * getResource() looks inside the project's
         * compiled resources.
         */

        java.net.URL imageURL =
                getClass().getResource(
                        imagePath
                );

        // -----------------------------------------------------
        // IMAGE NOT FOUND
        // -----------------------------------------------------

        if (imageURL == null) {

            JOptionPane.showMessageDialog(
                    this,

                    "Could not find image:\n\n"
                    + imagePath
                    + "\n\n"
                    + "Make sure the image is inside:\n"
                    + "src/main/resources/resources/",

                    "IMAGE NOT FOUND",

                    JOptionPane.ERROR_MESSAGE
            );

            return false;
        }

        // -----------------------------------------------------
        // LOAD IMAGE
        // -----------------------------------------------------

        ImageIcon icon =
                new ImageIcon(imageURL);

        Image image =
                icon.getImage();

        // -----------------------------------------------------
        // SCALE IMAGE
        // -----------------------------------------------------

        Image scaledImage =
                image.getScaledInstance(
                        64,
                        64,
                        Image.SCALE_SMOOTH
                );

        ImageIcon scaledIcon =
                new ImageIcon(
                        scaledImage
                );

        // -----------------------------------------------------
        // DISPLAY IMAGE
        // -----------------------------------------------------

        button.setIcon(
                scaledIcon
        );

        button.setDisabledIcon(
                scaledIcon
        );

        button.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        button.setVerticalAlignment(
                SwingConstants.CENTER
        );

        // -----------------------------------------------------
        // PREVENT CLICKING AGAIN
        // -----------------------------------------------------

        button.setEnabled(false);

        return true;
    }

    // =========================================================
    // DISABLE BOARD
    // =========================================================

    private void disableBoard() {

        JButton[] buttons = {

            jButton1,
            jButton2,
            jButton3,
            jButton4,

            jButton5,
            jButton6,
            jButton7,
            jButton8,

            jButton9,
            jButton10,
            jButton11,
            jButton12,

            jButton13,
            jButton14,
            jButton15,
            jButton16
        };

        for (JButton button : buttons) {

            button.setEnabled(false);
        }
    }

    // =========================================================
    // RESET GAME
    // =========================================================

    private void resetGame() {

        // -----------------------------------------------------
        // RESET VARIABLES
        // -----------------------------------------------------

        treasureCount = 0;

        gameOver = false;

        // -----------------------------------------------------
        // CREATE NEW RANDOM BOARD
        // -----------------------------------------------------

        initSymbols();

        // -----------------------------------------------------
        // GET ALL BUTTONS
        // -----------------------------------------------------

        JButton[] buttons = {

            jButton1,
            jButton2,
            jButton3,
            jButton4,

            jButton5,
            jButton6,
            jButton7,
            jButton8,

            jButton9,
            jButton10,
            jButton11,
            jButton12,

            jButton13,
            jButton14,
            jButton15,
            jButton16
        };

        // -----------------------------------------------------
        // RESET EVERY BUTTON
        // -----------------------------------------------------

        for (JButton button : buttons) {

            button.setIcon(null);

            button.setEnabled(true);

            button.setText("");

            button.setBackground(
                    BUTTON_GREEN
            );

            button.setForeground(
                    DARK_BROWN
            );

            button.setBorder(
                    BorderFactory.createLineBorder(
                            new Color(
                                    104,
                                    145,
                                    67
                            ),
                            2
                    )
            );
        }

        // -----------------------------------------------------
        // RESET TREASURE COUNTER
        // -----------------------------------------------------

        treasureLabel.setText(
                "💎 TREASURES: 0 / 13"
        );

        // -----------------------------------------------------
        // RESET STATUS
        // -----------------------------------------------------

        statusLabel.setText(
                "⛏ Dig carefully! Good luck!"
        );
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
        boardPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        headerPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        subtitleLabel = new javax.swing.JLabel();
        treasureLabel = new javax.swing.JLabel();
        bottomPanel = new javax.swing.JPanel();
        jButton17 = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setForeground(new java.awt.Color(124, 179, 66));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(124, 179, 66));

        boardPanel.setLayout(new java.awt.GridLayout(4, 4));
        boardPanel.add(jButton1);
        boardPanel.add(jButton2);
        boardPanel.add(jButton3);
        boardPanel.add(jButton4);
        boardPanel.add(jButton5);
        boardPanel.add(jButton6);
        boardPanel.add(jButton7);
        boardPanel.add(jButton8);
        boardPanel.add(jButton9);
        boardPanel.add(jButton10);
        boardPanel.add(jButton11);
        boardPanel.add(jButton12);
        boardPanel.add(jButton13);
        boardPanel.add(jButton14);
        boardPanel.add(jButton15);
        boardPanel.add(jButton16);

        titleLabel.setFont(new java.awt.Font("Monospaced", 1, 30)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(56, 106, 50));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("⛏ BLOCK TREASURE HUNT ⛏");
        headerPanel.add(titleLabel);

        subtitleLabel.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        subtitleLabel.setForeground(new java.awt.Color(78, 52, 46));
        subtitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subtitleLabel.setText("Find the treasures. Avoid Danger!");
        headerPanel.add(subtitleLabel);

        treasureLabel.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        treasureLabel.setForeground(new java.awt.Color(85, 214, 210));
        treasureLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        treasureLabel.setText("TREASURES:  0  /  13");
        headerPanel.add(treasureLabel);

        jButton17.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jButton17.setForeground(new java.awt.Color(78, 52, 46));
        jButton17.setText("NEW GAME!");
        jButton17.addActionListener(this::jButton17ActionPerformed);

        statusLabel.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(78, 52, 46));
        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusLabel.setText("Dig carefully! Good luck!");

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(56, 106, 50));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("made by kiacodesss");

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bottomPanelLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(statusLabel))
                    .addGroup(bottomPanelLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jButton17)))
                .addContainerGap(79, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addComponent(statusLabel)
                .addGap(18, 18, 18)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(boardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    new BlockTreasureHuntUI().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel boardPanel;
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel subtitleLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel treasureLabel;
    // End of variables declaration//GEN-END:variables
}
