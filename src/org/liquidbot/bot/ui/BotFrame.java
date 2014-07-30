package org.liquidbot.bot.ui;

import org.liquidbot.bot.Configuration;
import org.liquidbot.bot.Constants;
import org.liquidbot.bot.client.RSLoader;
import org.liquidbot.bot.utils.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

/**
 * Created by Kenneth on 7/29/2014.
 */
public class BotFrame extends JFrame implements WindowListener {

    private final Logger log = new Logger(getClass());

    private final RSLoader loader;
    private final BotButtonPanel buttonPanel;

    public BotFrame() {
        super(Constants.CLIENT_TITLE + " - v" + Constants.CLIENT_VERSION);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.buttonPanel = new BotButtonPanel();
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.getContentPane().add(buttonPanel);

        this.loader = new RSLoader();
        this.getContentPane().add(loader);

        this.addWindowListener(this);
    }

    public RSLoader loader(){
        return loader;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {
        log.info("Lost focus, locking canvas.");
        Configuration.drawCanvas = false;
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        log.info("Gained focus, unlocking canvas.");
        Configuration.drawCanvas = true;
    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
