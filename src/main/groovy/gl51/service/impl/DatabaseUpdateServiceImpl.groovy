package gl51.service.impl

import gl51.data.Photo
import gl51.service.PhotoService
import gl51.service.DatabaseUpdateService

import javax.inject.Inject

class DatabaseUpdateServiceImpl implements DatabaseUpdateService {

    @Inject
    PhotoService service

    @Override
    void updateDatabase(int id) {
        Photo photo = service.getPhoto(id)
        ///
    }
}
