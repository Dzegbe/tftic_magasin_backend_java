package be.technofutur.haveyourstyle.services.baseServices;

import java.util.List;

public interface UsersService<TDTO,TFORM,LONG> {
    public String delete(LONG id);
    public TDTO update(TFORM form);
    public List<TDTO> getAll();
} 
