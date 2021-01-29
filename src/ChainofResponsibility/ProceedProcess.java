/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChainofResponsibility;

import Iterator.Word;

/**
 *
 * @author okann
 */
public abstract class ProceedProcess {

    public ProceedProcess next;
    public ProceedProcess linkWith(ProceedProcess next) {
            this.next = next;
            return next;
    }
   
    public abstract boolean check(Word a,Word b);
    protected boolean checkNext(Word a, Word b) {
        if (next == null) {
            return true;
        }
        return next.check(a, b);
    }}
    