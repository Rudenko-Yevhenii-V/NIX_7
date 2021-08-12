package ru.rudenko.nix.Windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rudenko.nix.dao.InMemoryAuthorBookDao;
import ru.rudenko.nix.dao.InMemoryAuthorDao;
import ru.rudenko.nix.dao.InMemoryBookDao;
import ru.rudenko.nix.entity.Author;
import ru.rudenko.nix.entity.AuthorBook;
import ru.rudenko.nix.entity.Book;
import ru.rudenko.nix.service.CRUDService;

public class ShowModule extends JFrame {

  private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
  private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
  private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
  private CRUDService createOneBookWithAuthors = CRUDService.getInstance();
  private String[][] authorBooksIteration;
  JLabel book1 = new JLabel("name of book");
  JLabel authors = new JLabel("authors");

  public ShowModule() {
    super("CRUD for NIX 7!!!");
    setBounds(0, 0, 1200, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel panel1 = new JPanel();
    panel1.setBackground(Color.GRAY);
    JTextField jTextFieldBook11 = new JTextField("Harry Potter", 15);
    JTextField jTextFieldAuthor11 = new JTextField("J. K. Rowling", 15);
    JTextField jTextFieldAuthor12 = new JTextField("A. S. Buragova", 15);
    JTextField jTextFieldAuthor13 = new JTextField("E. M. Nix7", 15);
    JButton jButtonAdd = new JButton("add book");
    panel1.add(book1);
    panel1.add(jTextFieldBook11);
    panel1.add(authors);
    panel1.add(jTextFieldAuthor11);
    panel1.add(jTextFieldAuthor12);
    panel1.add(jTextFieldAuthor13);
    panel1.add(jButtonAdd);
    JPanel panelSeachBookByNameOfBook = new JPanel();
    JTextField jTextFieldSeachByBookName = new JTextField(15);
    JButton jButtonSeachByBookName = new JButton(" Search for a book by name of book");
    panelSeachBookByNameOfBook.add(jTextFieldSeachByBookName);
    panelSeachBookByNameOfBook.add(jButtonSeachByBookName);
    JPanel panelSeachBookByAuhtorName = new JPanel();
    JTextField jTextFieldSeachByAuthorName = new JTextField(15);
    JButton jButtonSeachByAuthorName = new JButton(" Search for a books by author name");
    panelSeachBookByAuhtorName.add(jTextFieldSeachByAuthorName);
    panelSeachBookByAuhtorName.add(jButtonSeachByAuthorName);
    mainPanel.add(panel1, BorderLayout.NORTH);
    JPanel seachPanel = new JPanel(new GridLayout(0, 1));
    mainPanel.add(seachPanel, BorderLayout.CENTER);
    seachPanel.add(panelSeachBookByNameOfBook);
    seachPanel.add(panelSeachBookByAuhtorName);
    JPanel autoGeneratePanel = new JPanel(new GridLayout(0, 6));
    //Draw All
    AuthorBook[] authorBooks = createOneBookWithAuthors.findAllAuthorsBooks();
    LOGGER_INFO.info(" All data \n" +
    InMemoryAuthorDao.getInstance().findAllAuthors().length + " aucthors " +
    InMemoryBookDao.getInstance().findAllBooks().length + " books " +
    InMemoryAuthorBookDao.getInstance().findAllAuthorsBooks().length + " aucthorsbooks "
    );
    if ((authorBooks.length > 1)) {
      authorBooksIteration = new String[authorBooks.length / 3][4];
      int countForOutPutAuthorBooks = 0;
      int countForOutPutAuthorBooks3 = 0;
      for (int i = 0; i < authorBooks.length; i++) {

        if (countForOutPutAuthorBooks == 0) {
          authorBooksIteration[countForOutPutAuthorBooks3][countForOutPutAuthorBooks] =
              createOneBookWithAuthors.findBookById(authorBooks[i].getIdBook()).getNameOfBook();
        }
        countForOutPutAuthorBooks++;
        if (countForOutPutAuthorBooks == 1) {
          authorBooksIteration[countForOutPutAuthorBooks3][countForOutPutAuthorBooks] =
              createOneBookWithAuthors.findAuthorById(authorBooks[i].getIdAuthor()).getName();
        }
        if (countForOutPutAuthorBooks == 2) {
          authorBooksIteration[countForOutPutAuthorBooks3][countForOutPutAuthorBooks] =
              createOneBookWithAuthors.findAuthorById(authorBooks[i].getIdAuthor()).getName();

        }
        if (countForOutPutAuthorBooks == 3) {
          authorBooksIteration[countForOutPutAuthorBooks3][countForOutPutAuthorBooks] =
              createOneBookWithAuthors.findAuthorById(authorBooks[i].getIdAuthor()).getName();
          countForOutPutAuthorBooks3++;
          countForOutPutAuthorBooks = 0;
        }
      }
      for (int i = 0; i < authorBooksIteration.length; i++) {
        JTextField jTextFieldBook = new JTextField(i);
        JTextField jTextFieldAuthor1Auto = new JTextField(i);
        JTextField jTextFieldAuthor2Auto = new JTextField(i);
        JTextField jTextFieldAuthor3Auto = new JTextField(i);
        JButton jButtonUpdate = new JButton("jButtonUpdate");
        JButton jButtonDelete = new JButton("jButtonDelete");
        autoGeneratePanel.add(jTextFieldBook);
        autoGeneratePanel.add(jTextFieldAuthor1Auto);
        autoGeneratePanel.add(jTextFieldAuthor2Auto);
        autoGeneratePanel.add(jTextFieldAuthor3Auto);
        autoGeneratePanel.add(jButtonUpdate);
        autoGeneratePanel.add(jButtonDelete);
        for (int j = 0; j < authorBooksIteration[i].length; j++) {
          switch (j) {
            case 0:
              jTextFieldBook.setText(authorBooksIteration[i][j]);
            case 1:
              jTextFieldAuthor1Auto.setText(authorBooksIteration[i][j]);
            case 2:
              jTextFieldAuthor2Auto.setText(authorBooksIteration[i][j]);
            case 3:
              jTextFieldAuthor3Auto.setText(authorBooksIteration[i][j]);
          }
        }
        int iter = i;
        jButtonUpdate
            .addActionListener(actionEvent -> jTextFieldBook.setText("jButtonUpdate" + iter));
        jButtonDelete
            .addActionListener(actionEvent -> jTextFieldBook.setText("jButtonDelete" + iter));
      }
    }
    mainPanel.add(autoGeneratePanel, BorderLayout.SOUTH);
    add(mainPanel, BorderLayout.SOUTH);
    pack();
    //jButtonAdd
    jButtonAdd.addActionListener(e -> {
          if (validatorFieldNotEmpty(jTextFieldBook11) &&
              validatorFieldNotEmpty(jTextFieldAuthor11)
          ) {
            if (createOneBookWithAuthors.findAllAuthorsBooks().length > 1) {
              try {
                //NullPointerException for LOGGER
                if (!createOneBookWithAuthors.findBookByName(jTextFieldBook11.getText()).equals(null)) {
                  this.setVisible(false);
                  this.removeAll();
                  new ShowModule().setVisible(true);
                  return;
                }
              } catch (NullPointerException er) {
              }
            }
            Book book1 = new Book();
            book1.setNameOfBook(jTextFieldBook11.getText());
            Author author1 = new Author();
            author1.setName(jTextFieldAuthor11.getText());
            Author[] authors = {author1};
            if (!jTextFieldAuthor12.getText().isEmpty()) {
              Author author2 = new Author();
              author2.setName(jTextFieldAuthor12.getText());
              authors = Arrays.copyOf(authors, authors.length + 1);
              authors[authors.length - 1] = author2;
            } else {
              Author author2 = new Author();
              author2.setName("-----");
              authors = Arrays.copyOf(authors, authors.length + 1);
              authors[authors.length - 1] = author2;
            }
            if (!jTextFieldAuthor13.getText().isEmpty()) {
              Author author3 = new Author();
              author3.setName(jTextFieldAuthor13.getText());
              authors = Arrays.copyOf(authors, authors.length + 1);
              authors[authors.length - 1] = author3;
            } else {
              Author author3 = new Author();
              author3.setName("-----");
              authors = Arrays.copyOf(authors, authors.length + 1);
              authors[authors.length - 1] = author3;
            }

            createOneBookWithAuthors.createBookAuthors(book1, authors);
            this.setVisible(false);
            this.removeAll();
            new ShowModule().setVisible(true);
          }
        }
    );
  }

  private boolean validatorFieldNotEmpty(JTextComponent jTextComponent) {
    if (jTextComponent.getText().isEmpty()) {
      jTextComponent.setBackground(Color.RED);
      return false;
    }
    return true;
  }
}