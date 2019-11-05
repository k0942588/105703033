package jfacetutorial.tableviewer;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableColumn;

import java.util.List;
import jfacetutorial.Article;
import jfacetutorial.DataModel;

public class TableViewerDemo {

    protected Shell shlTableviewerdemo;
    private Table table;

    /**
     * Launch the application.
     * @param args
     */
    public static void main(String[] args) {
        try {
            TableViewerDemo window = new TableViewerDemo();
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Open the window.
     */
    public void open() {
        Display display = Display.getDefault();
        createContents();
        shlTableviewerdemo.open();
        shlTableviewerdemo.layout();
        while (!shlTableviewerdemo.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    /**
     * Create contents of the window.
     */
    protected void createContents() {
        shlTableviewerdemo = new Shell();
        shlTableviewerdemo.setSize(366, 277);
        shlTableviewerdemo.setText("TableViewerDemo");
        shlTableviewerdemo.setLayout(new FillLayout(SWT.HORIZONTAL));
        
        TableViewer tableViewer = new TableViewer(shlTableviewerdemo, SWT.BORDER | SWT.FULL_SELECTION);        
        
        // Content Provider & Label Provider.
        ArticleTableCLProvider provider = new ArticleTableCLProvider();        
        tableViewer.setContentProvider(provider);        
        tableViewer.setLabelProvider(provider);        
        
        table = tableViewer.getTable();
        table.setLinesVisible(true);
        table.setHeaderVisible(true);
        
        TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
        tblclmnNewColumn.setWidth(148);
        tblclmnNewColumn.setText("Article");
        
        TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
        tblclmnNewColumn_1.setWidth(119);
        tblclmnNewColumn_1.setText("Author");
        
        // Set input data to TableViewer
        List<Article> articleList= DataModel.getArticles();
        tableViewer.setInput(articleList);
        

    }

}