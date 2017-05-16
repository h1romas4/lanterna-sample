import com.googlecode.lanterna.*
import com.googlecode.lanterna.gui2.*
import com.googlecode.lanterna.gui2.table.*
import com.googlecode.lanterna.gui2.dialogs.*
import com.googlecode.lanterna.screen.*
import com.googlecode.lanterna.terminal.*

/**
 * LanternaSample.
 */
class LanternaSample {
    /** Application instance */
    def static app = new LanternaSample()

    /** Singleton */
    def private LanternaSample() { }

    /**
     * start.
     *
     * @args
     */
    def int start(args) {
        // terminal create
        Terminal terminal = new DefaultTerminalFactory().createTerminal()
        // screen create
        Screen screen = new TerminalScreen(terminal)
        // gui create
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen)
        // window create
        BasicWindow window = new BasicWindow('lanterna example')

        // screen start
        screen.startScreen()

        // panel
        Panel panel = new Panel()
        // panel layout setting
        panel.setLayoutManager(new BorderLayout())

        // component
        Button cancel
        Table<String> table;

        // table data setting (test data)
        table = new Table<String>(["hostname", "IP address", "OS", "version"] as String[])
        def model = table.getTableModel()
        10.times {
            model.addRow(["www${it}.maple4ever.net", "10.0.0.${it}", "CentOS", "7.2"] as String[])
        }
        /*
        table.setVisibleRows(screen.getTerminalSize().getRows() - 8)
        table.setViewTopRow(0)
        table.setSelectedRow(0)
        */

        // table event setting
        table.setSelectAction {
            if(MessageDialog.showMessageDialog(
                gui
                , "Selected"
                , "${table.getTableModel().getRow(table.getSelectedRow())[0]}"
                , MessageDialogButton.No
                , MessageDialogButton.OK) == MessageDialogButton.OK) {
                // do sometrhing...
            }
        } as Runnable

        // button event setting
        cancel  = new Button("Cancel", {
            window.close()
        } as Runnable)

        // component add
        table.setLayoutData(BorderLayout.Location.TOP)
        cancel.setLayoutData(BorderLayout.Location.BOTTOM)
        panel.addComponent(table)
        panel.addComponent(cancel)
        window.setComponent(panel.withBorder(Borders.singleLine("main panal")))

        // main loop (blocking)
        try {
            gui.addWindowAndWait(window)
        } finally {
            screen.stopScreen()
        }

        return 0
    }

    /**
     * main.
     *
     * @args
     */
    def static void main(args) {
        System.exit(app.start(args))
    }
}