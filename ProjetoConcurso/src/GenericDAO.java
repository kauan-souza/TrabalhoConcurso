import java.util.List;

public interface GenericDAO <T extends Dominio , R>{

    public void add(T model);

    public List<T> buscar();

    public T filtrarPorId(R id );


}
