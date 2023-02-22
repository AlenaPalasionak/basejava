/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    public Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; i++) {
            while (storage[i] != null) {
                storage[i] = null;
            }
        }
    }

    void save(Resume r) {
        boolean resumeAalreadyExist = false;
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(r.uuid)) {
                System.out.println("The Resume with id= " + r.uuid + " already exists.");
                resumeAalreadyExist = true;
                break;
            }
        }
        if (!resumeAalreadyExist) {
            storage[size()] = r;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int indexOfDeletedResume = -1;
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                indexOfDeletedResume = i;
                break;
            }
        }
        if (indexOfDeletedResume == -1) {
            System.out.println("The Resume with id= " + uuid + " is not exist.");
        }
        if (indexOfDeletedResume >= 0) {
            for (int i = indexOfDeletedResume; i < size() + 1; i++) {
                if (storage[i] == null && storage[i + 1] != null) {
                    storage[i] = storage[i + 1];
                    storage[i + 1] = null;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size()];
        for (int i = 0; i < resumes.length; i++) {
            if (storage[i] != null) {
                resumes[i] = storage[i];
            }
        }
        return resumes;
    }

    int size() {
        int filledArrayCellsCounter = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                filledArrayCellsCounter++;
            } else {
                break;
            }
        }
        return filledArrayCellsCounter;
    }
}
