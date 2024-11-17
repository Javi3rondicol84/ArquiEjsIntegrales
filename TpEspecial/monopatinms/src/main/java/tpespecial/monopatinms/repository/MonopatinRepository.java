package tpespecial.monopatinms.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import tpespecial.monopatinms.dto.CantidadMonopatinesDto;
import tpespecial.monopatinms.dto.MonopatinDto;
import tpespecial.monopatinms.entity.Monopatin;

import java.util.List;

public interface MonopatinRepository extends MongoRepository<Monopatin,String> {

    @Aggregation(pipeline = {
            "{ $project: { " +
                    "idMonopatin: 1, " +
                    "encendido: 1, " +
                    "gps: 1, " +
                    "kilometrosRecorridos: 1, " +
                    "tiempoDeUso: 1, " +
                    "habilitado: 1, " +
                    "_id: 0 } }"
    })
    List<MonopatinDto> getAll();

    @Aggregation(pipeline = {
            "{ $group: { " +
                    "_id: null, " +
                    "cantidadOperacion: { $sum: { $cond: [ { $eq: [ { $ifNull: ['$habilitado', false] }, true ] }, 1, 0 ] } }, " +
                    "cantidadMantenimiento: { $sum: { $cond: [ { $eq: [ { $ifNull: ['$habilitado', false] }, false ] }, 1, 0 ] } } } }"
    })
    CantidadMonopatinesDto monopatinesMantenimientoVsOperacion();
}
