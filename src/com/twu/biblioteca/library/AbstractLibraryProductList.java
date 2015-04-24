package com.twu.biblioteca.library;

import java.util.ArrayList;

/**
 * Created by watsonarw on 24/04/15.
 */
public class AbstractLibraryProductList<T extends AbstractLibraryProduct> extends ArrayList<T> {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T product : this) {
            sb.append(" " + (this.indexOf(product)) + " | ");
            sb.append(product.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getAvailableList() {
        StringBuilder sb = new StringBuilder();
        for(T product : this) {
            if (!product.isCheckedOut()) {
                sb.append(" " + (this.indexOf(product)) + " | ");
                sb.append(product.toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }


    public String getCheckedOutList() {
        StringBuilder sb = new StringBuilder();
        for(T product : this) {
            if (product.isCheckedOut()) {
                sb.append(" " + (this.indexOf(product)) + " | ");
                sb.append(product.toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public boolean exists(int id) {
        try {
            this.get(id);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }


    public void checkIn(int id) {
        if (exists(id)) {
            this.get(id).checkIn();
        }
    }

    public boolean isCheckedOut(int id) {
        return this.get(id).isCheckedOut();
    }


    public void checkOut(int id) {
        if (exists(id)) {
            this.get(id).checkOut();
        }
    }

    @Override
    public T get(int idx) {
        return super.get(idx - 1);
    }

    @Override
    public int indexOf(Object o) {
        return super.indexOf(o) + 1;
    }
}
