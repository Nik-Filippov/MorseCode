package com.credible.tools.MorseCode.ui;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.dom.DomEvent;
import com.vaadin.flow.server.StreamResource;

import static com.credible.tools.MorseCode.i8n.MorseCodeCaptions.CLICK_TO_DOWNLOAD_TEXT;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadFileAnchor extends Anchor {

    private static final Logger logger = LoggerFactory.getLogger(DownloadFileAnchor.class);
    private InputStream inputStream;

    private String fileName;

    public void init(final String fileName, final InputStream inputStream) {
        if (this.inputStream != null && this.inputStream != inputStream) {
            try {
                this.inputStream.close();
            } catch (IOException ex) {
                logger.error(ex.getMessage());
            }
        }

        this.inputStream = inputStream;
        this.fileName = fileName;

        this.setHref(new StreamResource(fileName, () -> inputStream));
        this.setText(CLICK_TO_DOWNLOAD_TEXT + " \"" + fileName + "\"");
        this.setVisible(true);
        this.getElement().setAttribute("download", true);
        this.getElement().addEventListener("click", this::handleClick);
    }

    private void handleClick(DomEvent event) {
        this.setVisible(false);
        this.removeAll();
        // Delete original file.
        try {
            Files.delete(Paths.get(fileName));

            logger.info("Successfully deleted file [" + fileName + "] from disk.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
