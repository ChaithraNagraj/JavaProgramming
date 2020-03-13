package com.bridgelabz.designpatten.behavioral.visitor;

public interface ShoppingCartVisitor {
	int visit(Book book);
	int visit(Fruit fruit);

}
