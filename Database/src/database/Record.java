/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.Objects;

/**
 *
 * @author Matteo
 */

    public class Record {
        
    String field1,field2;
    int field3;
    
    
    public Record(){}
    
    public Record(String field1, String field2, int field3){
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.field1);
        hash = 53 * hash + Objects.hashCode(this.field2);
        hash = 53 * hash + this.field3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Record other = (Record) obj;
        if (this.field3 != other.field3) {
            return false;
        }
        if (!Objects.equals(this.field1, other.field1)) {
            return false;
        }
        if (!Objects.equals(this.field2, other.field2)) {
            return false;
        }
        return true;
    }
}
