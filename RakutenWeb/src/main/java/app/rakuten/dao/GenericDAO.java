package app.rakuten.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * DAO Interface for commons methods
 * 
 * @author Sergey Ogarkov
 *
 * @param <T>
 *            Generic class for DAO
 */
public interface GenericDAO<T extends Serializable> {
	/**
	 * Found entity by Id
	 * 
	 * @param id
	 * @return Entity
	 */
	public T findOne(final long id);

	/**
	 * Found all Entity
	 * 
	 * @return List of the Entityû
	 */
	public List<T> findAll();

	/**
	 * Create new Entity
	 * 
	 * @param Entity
	 */
	public void create(final T entity);

	/**
	 * Update to change exists Entity
	 * 
	 * @param Entity
	 * @return Entity with changing
	 */
	public T update(final T entity);

	/**
	 * Delete entity by object Entity
	 * 
	 * @param Entity
	 */
	public void delete(final T entity);

	/**
	 * Delete Entity
	 * 
	 * @param id
	 *            of the Entity
	 */
	public void deleteById(final long entityId);

}
