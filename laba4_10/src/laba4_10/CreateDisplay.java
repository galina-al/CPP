package laba4_10;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Класс для создания окна
 * 
 * @author Галя
 *
 */
public class CreateDisplay {
	private Display display;
	private Shell shell;
	private GridLayout gridLayout = new GridLayout();

	private Label LabelForInformation;
	private MessageBox messegeBox;
	private Label labelNumberDebaters;
	private Label labelNumberPrize;
	private Label labelWinner;
	private Label labelForNameWinner;
	private Text textNumberDebaters;
	private Text textNumberPrize;
	private Button buttonArgue;

	public CreateDisplay() {
		display = new Display();
	}

	/**
	 * Создает окно
	 */
	public void CreateWindow() {
		shell = new Shell(display);
		shell.setText("Спорщики");
		shell.setSize(400, 200);
		shell.setLayout(gridLayout);

		gridLayout.numColumns = 2;

		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.horizontalSpan = 2;

		LabelForInformation = new Label(shell, SWT.PUSH);
		LabelForInformation.setText("Введите количество спорщиков и число, являющееся условием конца спора.");
		LabelForInformation.setLayoutData(gridData);

		GridData gridData1 = new GridData();
		gridData1.horizontalSpan = 1;
		gridData1.horizontalAlignment = GridData.BEGINNING;

		labelNumberDebaters = new Label(shell, SWT.FILL);
		labelNumberDebaters.setText("Количество спрощиков: ");
		labelNumberDebaters.setLayoutData(gridData1);

		textNumberDebaters = new Text(shell, SWT.BEGINNING);
		textNumberDebaters.setLayoutData(gridData1);

		GridData gridData2 = new GridData();
		gridData1.horizontalSpan = 1;
		gridData1.horizontalAlignment = GridData.BEGINNING;

		labelNumberPrize = new Label(shell, SWT.FILL);
		labelNumberPrize.setText("Условие выхода: ");
		labelNumberPrize.setLayoutData(gridData2);

		textNumberPrize = new Text(shell, SWT.BEGINNING);
		textNumberPrize.setLayoutData(gridData1);

		GridData gridDataForButton = new GridData();
		gridDataForButton.horizontalSpan = 2;
		gridDataForButton.horizontalAlignment = GridData.BEGINNING;

		buttonArgue = new Button(shell, SWT.CENTER);
		buttonArgue.setText("Спорить");
		buttonArgue.setLayoutData(gridDataForButton);

		GridData gridData3 = new GridData();
		gridData1.horizontalSpan = 1;
		gridData1.horizontalAlignment = GridData.BEGINNING;

		labelWinner = new Label(shell, SWT.FILL);
		labelWinner.setText("Победитель: ");
		labelWinner.setLayoutData(gridData3);

		labelForNameWinner = new Label(shell, SWT.BEGINNING);
		labelForNameWinner.setText(" ");
		labelForNameWinner.setLayoutData(gridData3);

		/**
		 * Событие при нажатии на кнопку "Спорить"
		 */
		buttonArgue.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				int numberDebaters, numberPrize;
				if (textNumberDebaters.getText().isEmpty()) {
					messegeBox = new MessageBox(shell, SWT.ERROR | SWT.OK);
					messegeBox.setText("Error!");
					messegeBox.setMessage("Введите количество спорщиков!");
					messegeBox.open();
					return;
				} else {
					numberDebaters = Integer.parseInt(textNumberDebaters.getText());
				}
				if (textNumberPrize.getText().isEmpty()) {
					messegeBox = new MessageBox(shell, SWT.ERROR | SWT.OK);
					messegeBox.setText("Error!");
					messegeBox.setMessage("Введите условие окончания спора!");
					messegeBox.open();
					return;
				} else {
					numberPrize = Integer.parseInt(textNumberPrize.getText());
				}

				MyThread MT = new MyThread();
				MT.SetMyThread(numberDebaters, numberPrize);
				MT.CreateDebaters();
				labelForNameWinner.setText(MT.nameWinner);
			}
		});

		shell.open();
		while (!shell.isDisposed()) {
			// process the next event, wait when none available
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

		display.dispose();
	}

}
