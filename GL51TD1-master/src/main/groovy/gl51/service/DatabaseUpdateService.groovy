package gl51.service

import gl51.data.Photo

/**
 * Ceci permet de mettre à jour la base de données
 */
interface DatabaseUpdateService {

    /**
     * Met à jour la base de données
     * @return
     */
    void updateDatabase(int id)
}
