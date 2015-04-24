package com.twu.biblioteca.library;

import java.util.ArrayList;

/**
 * Created by watsonarw on 24/04/15.
 */
public class AbstractLibraryProductList<T extends AbstractLibraryProduct> extends ArrayList<T> {

    @Override
    public String toString() {
        return getList(false, true);
    }

    public String getAvailableList() {
        return getList(false, false);
    }


    public String getCheckedOutList() {
        return getList(true, false);
    }

    private String getList(boolean checkedOut, boolean all) {
        StringBuilder sb = new StringBuilder();
        for(T product : this) {
            if ((all) || (product.isCheckedOut() == checkedOut)) {
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
