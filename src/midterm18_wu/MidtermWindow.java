package midterm18_wu;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MidtermWindow {

	protected Shell shlMidterm;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MidtermWindow window = new MidtermWindow();
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
		shlMidterm.open();
		shlMidterm.layout();
		while (!shlMidterm.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMidterm = new Shell();
		shlMidterm.setSize(380, 225);
		shlMidterm.setText("Midterm Window");
		shlMidterm.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite = new Composite(shlMidterm, SWT.NONE);
		composite.setBounds(0, 0, 64, 64);
		composite.setLayout(new GridLayout(4, false));
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(0, 0, 59, 14);
		lblNewLabel.setText("Next Page");
		
		Button btnRadioButton = new Button(composite, SWT.RADIO);
		btnRadioButton.setSelection(true);
		btnRadioButton.setBounds(0, 0, 90, 18);
		btnRadioButton.setText("Read");
		new Label(composite, SWT.NONE);
		
		DateTime dateTime = new DateTime(composite, SWT.BORDER);
		dateTime.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		new Label(composite, SWT.NONE);
		
		text = new Text(composite, SWT.BORDER);
		GridData gd_text = new GridData(SWT.FILL, SWT.FILL, false, false, 3, 4);
		gd_text.widthHint = 251;
		text.setLayoutData(gd_text);
		
		Button btnCheckButton = new Button(composite, SWT.CHECK);
		btnCheckButton.setBounds(0, 0, 94, 18);
		btnCheckButton.setText("Yes");
		
		Button btnCheckButton_1 = new Button(composite, SWT.CHECK);
		btnCheckButton_1.setBounds(0, 0, 94, 18);
		btnCheckButton_1.setText("No");
		
		Button btnNotSure = new Button(composite, SWT.CHECK);
		btnNotSure.setBounds(0, 0, 94, 18);
		btnNotSure.setText("Not sure");
		new Label(composite, SWT.NONE);
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblNewLabel.setText("Back Page");
			}
		});
		GridData gd_btnNewButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton.widthHint = 93;
		btnNewButton.setLayoutData(gd_btnNewButton);
		btnNewButton.setText("Back");
		new Label(composite, SWT.NONE);
		
		Button btnNewButton_1 = new Button(composite, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblNewLabel.setText("Next Page");
			}
		});
		
		GridData gd_btnNewButton_1 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton_1.widthHint = 93;
		btnNewButton_1.setLayoutData(gd_btnNewButton_1);
		btnNewButton_1.setText("Next");

	}
}
