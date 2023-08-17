package com.uu.common;
 
import org.springframework.stereotype.Repository;
 
/**
 * 
 * @author uuEstHorrible
 *
 */
@Repository
public interface EntityMapper {
    /**
     * refer
     * @param i 
     * @return
     */
	public Object refer(Object obj);
 
	/**
	 * insert
	 * @return
	 */
    public Object insert();
 
    /**
     * update
     * @return
     */
    public Object update();
 
    /**
     * delete
     * @return
     */
    public Object delete();
}