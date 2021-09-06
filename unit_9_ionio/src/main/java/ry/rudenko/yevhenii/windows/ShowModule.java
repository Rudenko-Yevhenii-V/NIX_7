package ry.rudenko.yevhenii.windows;

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
import ry.rudenko.yevhenii.dao.impl.AuthorBookDaoImpl;
import ry.rudenko.yevhenii.dao.impl.AuthorDaoImpl;
import ry.rudenko.yevhenii.dao.impl.BookDaoImpl;
import ry.rudenko.yevhenii.entity.Author;
import ry.rudenko.yevhenii.entity.AuthorBook;
import ry.rudenko.yevhenii.entity.Book;
import ry.rudenko.yevhenii.service.impl.CRUDServiceImpl;


public class ShowModule extends JFrame {

  private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
  private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
  private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");
//  private final CRUDServiceImpl createOneBookWithAuthors = CRUDServiceImpl.getInstance();
  private final static CRUDServiceImpl createOneBookWithAuthors = CRUDServiceImpl.getInstance();
  private final JTextField jTextFieldBook11 = new JTextField("Harry Potter", 15);
  private final JTextField jTextFieldAuthor11 = new JTextField("J. K. Rowling", 15);
  private final JTextField jTextFieldAuthor12 = new JTextField("A. S. Buragova", 15);
  private final JTextField jTextFieldAuthor13 = new JTextField("E. M. Nix7", 15);


  public ShowModule() {
    super("CRUD for NIX 7!!!");
    setBounds(0, 0, 1200, 1000);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panelAddData = new JPanel();
    panelAddData.setBackground(Color.GRAY);
    JLabel book11 = new JLabel("name of book");
    panelAddData.add(book11);
    panelAddData.add(jTextFieldBook11);
    JLabel authors1 = new JLabel("authors");
    panelAddData.add(authors1);
    panelAddData.add(jTextFieldAuthor11);
    panelAddData.add(jTextFieldAuthor12);
    panelAddData.add(jTextFieldAuthor13);
    JButton jButtonAdd = new JButton("add book");
    panelAddData.add(jButtonAdd);
    JPanel panelSeachBookByNameOfBook = new JPanel();
    JTextField jTextFieldSeachByBookName = new JTextField(15);
    panelSeachBookByNameOfBook.add(jTextFieldSeachByBookName);
    JButton jButtonSeachByBookName = new JButton(" Search for a book by name of book");
    panelSeachBookByNameOfBook.add(jButtonSeachByBookName);
    JPanel panelSeachBookByAuhtorName = new JPanel();
    JTextField jTextFieldSeachByAuthorName = new JTextField(15);
    panelSeachBookByAuhtorName.add(jTextFieldSeachByAuthorName);
    JButton jButtonSeachByAuthorName = new JButton(" Search for a books by author name");
    panelSeachBookByAuhtorName.add(jButtonSeachByAuthorName);
    JPanel mainPanel = new JPanel(new BorderLayout());
    mainPanel.add(panelAddData, BorderLayout.NORTH);
    //Draw All
    AuthorBook[] authorBooks = createOneBookWithAuthors.findAllAuthorsBooks();

    LOGGER_INFO.info(" All data \n" +
        new AuthorDaoImpl().findAllAuthors().length + " aucthors " +
        new BookDaoImpl().findAllBooks().length + " books " +
        new AuthorBookDaoImpl().findAllAuthorsBooks().length + " aucthorsbooks "
    );
    JPanel autoGeneratePanel = new JPanel(new GridLayout(0, 6));
    if ((authorBooks.length > 1)) {

      String[][] authorBooksIteration = new String[authorBooks.length / 3][4];
      int countForOutPutAuthorBooks = 0;
      int countForOutPutAuthorBooks3 = 0;
      for (AuthorBook authorBook : authorBooks) {
        if (countForOutPutAuthorBooks == 0) {
          if (!(createOneBookWithAuthors.findBookById(authorBook.getIdBook()) == null)) {
            authorBooksIteration[countForOutPutAuthorBooks3][countForOutPutAuthorBooks] =
                createOneBookWithAuthors.findBookById(authorBook.getIdBook()).getNameOfBook();
          }
        }
        countForOutPutAuthorBooks++;
        if (countForOutPutAuthorBooks == 1) {
          authorBooksIteration[countForOutPutAuthorBooks3][countForOutPutAuthorBooks] =
              createOneBookWithAuthors.findAuthorById(authorBook.getIdAuthor()).getName();
        }
        if (countForOutPutAuthorBooks == 2) {
          authorBooksIteration[countForOutPutAuthorBooks3][countForOutPutAuthorBooks] =
              createOneBookWithAuthors.findAuthorById(authorBook.getIdAuthor()).getName();

        }
        if (countForOutPutAuthorBooks == 3) {
          authorBooksIteration[countForOutPutAuthorBooks3][countForOutPutAuthorBooks] =
              createOneBookWithAuthors.findAuthorById(authorBook.getIdAuthor()).getName();
          countForOutPutAuthorBooks3++;
          countForOutPutAuthorBooks = 0;
        }
      }
      for (int i = 0; i < authorBooksIteration.length; i++) {
        JTextField jTextFieldBook = new JTextField(i);
        JTextField jTextFieldBookSave = new JTextField(i);
        jTextFieldBookSave.setVisible(false);
        JTextField jTextFieldAuthor1Auto = new JTextField(i);
        JTextField jTextFieldAuthor1AutoSave = new JTextField(i);
        JTextField jTextFieldAuthor2Auto = new JTextField(i);
        JTextField jTextFieldAuthor2AutoSave = new JTextField(i);
        JTextField jTextFieldAuthor3Auto = new JTextField(i);
        JTextField jTextFieldAuthor3AutoSave = new JTextField(i);
        JButton jButtonUpdate = new JButton("Update");
        JButton jButtonDelete = new JButton("Delete");
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
              jTextFieldBookSave.setText(authorBooksIteration[i][j]);
            case 1:
              jTextFieldAuthor1Auto.setText(authorBooksIteration[i][j]);
              jTextFieldAuthor1AutoSave.setText(authorBooksIteration[i][j]);
            case 2:
              jTextFieldAuthor2Auto.setText(authorBooksIteration[i][j]);
              jTextFieldAuthor2AutoSave.setText(authorBooksIteration[i][j]);
            case 3:
              jTextFieldAuthor3Auto.setText(authorBooksIteration[i][j]);
              jTextFieldAuthor3AutoSave.setText(authorBooksIteration[i][j]);
          }
        }

        //jButtonUpdate
        jButtonUpdate
            .addActionListener(actionEvent -> {

              CRUDServiceImpl.getInstance()
                      .updateAllData(jTextFieldBook.getText(), jTextFieldBookSave.getText()
                          , jTextFieldAuthor1Auto.getText(), jTextFieldAuthor1AutoSave.getText()
                          , jTextFieldAuthor2Auto.getText(), jTextFieldAuthor2AutoSave.getText()
                          , jTextFieldAuthor3Auto.getText(), jTextFieldAuthor3AutoSave.getText());
                  this.setVisible(false);
                  this.removeAll();
                  new ShowModule().setVisible(true);
                }
            );
        //jButtonDelete
        jButtonDelete
            .addActionListener(actionEvent -> {
                  LOGGER_WARN.warn("jButtonDelete try delete " + jTextFieldBook.getText());
                  createOneBookWithAuthors.delete(new BookDaoImpl().
                      findBookByName(jTextFieldBook.getText())
                      .getId());
                  this.setVisible(false);
                  this.removeAll();
                  new ShowModule().setVisible(true);
                }
            );

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
                LOGGER_ERROR.error("NullPointerException for LOGGER" + er);
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
              author2.setName("----- _");
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