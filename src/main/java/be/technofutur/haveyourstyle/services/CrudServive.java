package be.technofutur.haveyourstyle.services;

public interface CrudServive<TDTO,TFORMINSERT,TUPDATE,LONG> {
    public TDTO getAll();
    public TDTO getOne(LONG id);
    public TDTO insert(TFORMINSERT form);
    public TDTO update(LONG id,TUPDATE form) ;
    public Long delete(LONG id); 
}
