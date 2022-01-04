package be.technofutur.haveyourstyle.mappers;

public interface BaseMapper<TDTO,TFORM,TENTITY> {
    public TDTO entityToDto(TENTITY entity);
    public TENTITY formToEntity(TFORM form);
    public TENTITY dtoToEntity(TDTO dto);

}
