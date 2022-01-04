package be.technofutur.haveyourstyle.mappers;

public interface BaseCustomerMapper<TDTO,TFORMREGISTER,TFORMLOGIN,TENTITY> {
    public TDTO entityToDto(TENTITY entity);
    public TENTITY register(TFORMREGISTER formRegister);
    public TENTITY dtoToEntity(TDTO dto);
}
