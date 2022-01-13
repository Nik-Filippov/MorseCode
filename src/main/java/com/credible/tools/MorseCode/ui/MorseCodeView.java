package com.credible.tools.MorseCode.ui;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

import static com.credible.tools.MorseCode.i8n.MorseCodeCaptions.*;
import static com.credible.tools.MorseCode.ui.CssClasses.*;


@Theme(value = Lumo.class, variant = Lumo.DARK)
@CssImport("./styles/shared-styles.css")
@PageTitle(APP_HEADER_TEXT)
@Route("")
public class MorseCodeView extends VerticalLayout {
    private static final Logger logger = LoggerFactory.getLogger(MorseCodeView.class);

    private MorseCodeView() {

        final Translator tran = new Translator();

        final H2 pageTitle = new H2(APP_HEADER_TEXT);
        pageTitle.getClassNames().add(DEFAULT_TITLE_CLASS);

        final H4 pageSubTitle = new H4(APP_SUB_HEADER_TEXT);
        pageSubTitle.getClassNames().add(DEFAULT_ENTRIES_CLASS);

        final TextArea textAreaInput = new TextArea();
        textAreaInput.getClassNames().add(DEFAULT_ENTRIES_CLASS);

        final TextArea textAreaOutput = new TextArea();
        textAreaOutput.getClassNames().add(DEFAULT_ENTRIES_CLASS);
        textAreaOutput.setVisible(false);

        RadioButtonGroup<String> radioGroup = new RadioButtonGroup<>();
        radioGroup.getClassNames().add(DEFAULT_RADIO_BUTTONS_CLASS);
        radioGroup.setLabel(RADIO_GROUP_LABEL);
        radioGroup.setItems(ENGLISH_TO_MORSE, MORSE_TO_ENGLISH);
        radioGroup.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        radioGroup.setValue(ENGLISH_TO_MORSE);

        final ListItem list1 = new ListItem();
        list1.getClassNames().add(TOP_ENTRIES_CLASS);
        list1.add(INFO1);

        final ListItem list2 = new ListItem();
        list2.getClassNames().add(DEFAULT_ENTRIES_CLASS);
        list2.add(INFO2);

        final ListItem list3 = new ListItem();
        list3.getClassNames().add(DEFAULT_ENTRIES_CLASS);
        list3.add(INFO3);

        final ListItem list4 = new ListItem();
        list4.getClassNames().add(DEFAULT_ENTRIES_CLASS);
        list4.add(INFO4);

        final ListItem list5 = new ListItem();
        list5.getClassNames().add(DEFAULT_ENTRIES_CLASS);
        list5.add(INFO5);

        final Button createTextButton = new Button(CREATE_FILLED_TEXT_AREA);
        createTextButton.getClassNames().add(DEFAULT_BUTTONS_CLASS);

        final Button createPDFDocumentButton = new Button(CREATE_PDF_DOCUMENT);
        createPDFDocumentButton.getClassNames().add(DEFAULT_BUTTONS_CLASS);

        final DownloadFileAnchor downloadPDFFileAnchor = new DownloadFileAnchor();
        downloadPDFFileAnchor.getClassNames().add(DEFAULT_DOWNLOAD_CLASS);
        downloadPDFFileAnchor.setVisible(false);

        final Footer footer1 = new Footer();
        footer1.getClassNames().add(TOP_FOOTER_CLASS);
        footer1.setText(FOOTER_INFO1);

        final Footer footer2 = new Footer();
        footer2.getClassNames().add(DEFAULT_FOOTER_CLASS);
        footer2.setText(FOOTER_INFO2);

        //Clear when the mode is switched.
        radioGroup.addValueChangeListener(event -> {
            if (event.getValue() != null) {
                textAreaInput.clear();
                textAreaOutput.clear();
                textAreaOutput.setVisible(false);
                downloadPDFFileAnchor.setVisible(false);
            }
        });

        Grid<SymbolPair> grid = new Grid<>(SymbolPair.class);
        grid.setItems(Translator.getMorseList());
        grid.getClassNames().add(DEFAULT_GRID_CLASS);
        grid.setHeightByRows(true);
        grid.setColumns("english", "morse");

        //Create text
        createTextButton.addClickListener(buttonClickEvent -> {
            try {
                String input, output;
                //English to Morse (TEXT)
                if(radioGroup.getValue().equals(ENGLISH_TO_MORSE)) {
                    input = textAreaInput.getValue();
                    logger.info("Input: [" + input + "].");
                    output = tran.tranSentEngToMorse(input);
                    logger.info("Output: [" + output + "].");
                    textAreaOutput.setValue(output);
                    if(textAreaOutput.isEmpty() && !textAreaInput.isEmpty()){
                        textAreaOutput.setValue(OUTPUT_ERROR_MESSAGE);
                    }
                    textAreaOutput.setVisible(true);
                }

                //Morse to English (TEXT)
                else{
                    input = textAreaInput.getValue() + "   ";
                    logger.info("Input: [" + input + "].");
                    output = tran.tranSentMorseToEng(input);
                }
                logger.info("Output: [" + output + "].");
                textAreaOutput.setValue(output);
                if(textAreaOutput.isEmpty() && !textAreaInput.isEmpty()){
                    textAreaOutput.setValue(OUTPUT_ERROR_MESSAGE);
                }
                textAreaOutput.setVisible(true);
                }
            catch (Exception e) {
                logger.error(e.getMessage());
            }
        });

        //Create PDF
        createPDFDocumentButton.addClickListener(buttonClickEvent -> {
            try {
                String input, output;
                //English to Morse (PDF)
                if(radioGroup.getValue().equals(ENGLISH_TO_MORSE)) {
                    input = textAreaInput.getValue();
                    logger.info("Input: [" + input + "].");
                    output = tran.tranSentEngToMorse(input);
                    logger.info("Output: [" + output + "].");
                    //Write to PDF
                    logger.info("Creating PDF document from: [" + input + "].");
                    final String file_name = UUID.randomUUID() + ".pdf";
                    logger.info("Generated filename is: [" + file_name + "].");
                    final Document pdfDocument = new Document();
                    final OutputStream targetPdfDocument = new FileOutputStream(file_name);
                    PdfWriter writer = PdfWriter.getInstance(pdfDocument, targetPdfDocument);
                    pdfDocument.open();
                    pdfDocument.add(new Paragraph(output));
                    pdfDocument.close();
                    downloadPDFFileAnchor.init(file_name, new FileInputStream(file_name));
                }
                //Morse to English (PDF)
                else {
                    input = textAreaInput.getValue() + "   ";
                    logger.info("Input: [" + input + "].");
                    output = tran.tranSentMorseToEng(input);
                    logger.info("Output: [" + output + "].");
                    //Write to PDF
                    logger.info("Creating PDF document from: [" + textAreaInput.getValue() + "].");
                    final String file_name = UUID.randomUUID() + ".pdf";
                    logger.info("Generated filename is: [" + file_name + "].");
                    final Document pdfDocument = new Document();
                    final OutputStream targetPdfDocument = new FileOutputStream(file_name);
                    PdfWriter writer = PdfWriter.getInstance(pdfDocument, targetPdfDocument);
                    pdfDocument.open();
                    pdfDocument.add(new Paragraph(output));
                    pdfDocument.close();
                    downloadPDFFileAnchor.init(file_name, new FileInputStream(file_name));
                }
                downloadPDFFileAnchor.setVisible(true);
                logger.info("Successfully created PDF document as per user`s request.");
            }
            catch (Exception e) {
                logger.error(e.getMessage());
            }
        });
        //Add all elements
        add(pageTitle, pageSubTitle, radioGroup, textAreaInput, createTextButton, createPDFDocumentButton,
                textAreaOutput, downloadPDFFileAnchor, list1, list2, list3, list4,
                list5, grid, footer1, footer2);

        logger.info("Successfully loaded page.");
    }
}