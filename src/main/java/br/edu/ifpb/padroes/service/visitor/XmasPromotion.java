package br.edu.ifpb.padroes.service.visitor;

import br.edu.ifpb.padroes.model.Book;
import br.edu.ifpb.padroes.model.Electronic;

import java.math.BigDecimal;

public class XmasPromotion implements Visitor {

    private static final BigDecimal BOOK_DISCOUNT = BigDecimal.valueOf(0.5); // 50 %
    private static final BigDecimal ELECTRONIC_DISCOUNT = BigDecimal.valueOf(0.2); // 20 %

    @Override
    public BigDecimal visit(Book book) {
        return book.getPrice().multiply(BOOK_DISCOUNT);
    }

    @Override
    public BigDecimal visit(Electronic electronic) {
        return electronic.getPrice().multiply(ELECTRONIC_DISCOUNT);
    }

}