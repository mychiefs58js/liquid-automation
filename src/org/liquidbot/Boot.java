package org.liquidbot;

import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import org.liquidbot.bot.Configuration;
import org.liquidbot.bot.client.parser.HookReader;
import org.liquidbot.bot.ui.BotFrame;
import org.liquidbot.bot.utils.Logger;
import org.liquidbot.bot.utils.NetUtils;
import org.liquidbot.bot.utils.Utilities;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;

/**
 * Created by Kenneth on 7/29/2014.
 */
public class Boot {

    private static final Logger log = new Logger(Boot.class);

    public static void main(String[] args) {
        JPopupMenu.setDefaultLightWeightPopupEnabled(true);

        log.info("Parsing hooks..");
        HookReader.init();

        log.info("Lauching client..");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {
                    UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
                } catch (UnsupportedLookAndFeelException | ParseException e) {
                    e.printStackTrace();
                }

                final Image iconImage = Utilities.getLocalImage("/resources/liquidicon.png");

                Configuration.botFrame = new BotFrame();
                Configuration.botFrame.setIconImage(iconImage);
                Configuration.botFrame.pack();
                Configuration.botFrame.setVisible(true);
            }
        });
    }


}