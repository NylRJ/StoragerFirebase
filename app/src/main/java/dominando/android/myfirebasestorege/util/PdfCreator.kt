package com.example.mac.firebasecursods.kotlin.util


import com.itextpdf.text.Document
import com.itextpdf.text.Element
import com.itextpdf.text.Paragraph
import com.itextpdf.text.Phrase
import com.itextpdf.text.Rectangle
import com.itextpdf.text.pdf.ColumnText
import com.itextpdf.text.pdf.PdfPageEventHelper
import com.itextpdf.text.pdf.PdfWriter

class PdfCreator : PdfPageEventHelper() {


    internal var phrases = arrayOfNulls<Phrase>(2)
    internal var numero_pagina: Int = 0


    override fun onOpenDocument(writer: PdfWriter?, document: Document?) {

        phrases[0] = Phrase("pdf")
    }


    override fun onChapter(writer: PdfWriter?, document: Document?, paragraphPosition: Float, title: Paragraph) {

        phrases[1] = Phrase(title.content)
        numero_pagina = 1

    }

    override fun onStartPage(writer: PdfWriter?, document: Document?) {

        numero_pagina++

    }


    override fun onEndPage(writer: PdfWriter, document: Document?) {

        val rectangle = writer.getBoxSize("box_a")

        ColumnText.showTextAligned(writer.directContent, Element.ALIGN_RIGHT, Phrase(""),
                rectangle.right, rectangle.top, 0f)


        ColumnText.showTextAligned(writer.directContent, Element.ALIGN_RIGHT, Phrase(String.format("%d", numero_pagina)),
                (rectangle.right + rectangle.right) / 2, rectangle.bottom - 18, 0f)


    }
}
