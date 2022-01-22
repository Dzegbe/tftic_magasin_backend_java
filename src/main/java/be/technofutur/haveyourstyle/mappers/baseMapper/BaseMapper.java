package be.technofutur.haveyourstyle.mappers.baseMapper;

public interface BaseMapper<TDTO,TFORM,TENTITY> {
    public TDTO entityToDto(TENTITY entity);
    public TENTITY formToEntity(TFORM form,TENTITY entity);
    public TENTITY dtoToEntity(TDTO dto);

}
