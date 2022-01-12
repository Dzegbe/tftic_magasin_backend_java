package be.technofutur.haveyourstyle.mappers.baseMapper;

public interface BaseCustomerMapper<TDTO,TFORMREGISTER,TFORMLOGIN,TENTITY> {
    public TDTO entityToDto(TENTITY entity);
    public TENTITY dtoToEntity(TDTO dto);
}
