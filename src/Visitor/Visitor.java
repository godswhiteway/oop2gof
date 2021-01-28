/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visitor;

import Iterator.Word;

/**
 *
 * @author okann
 */
public interface Visitor {
    public void visit(Word word);
    public void visit(String word);

}
