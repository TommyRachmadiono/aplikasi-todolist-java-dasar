import java.util.Scanner;

public class AplikasiTodoList {
  public static String[] todoList = new String[10];
  public static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    viewShowTodoList();
  }

  /** Menampilkan TodoList */
  public static void showTodoList() {
    System.out.println("TODO LIST");
    for (int index = 0; index < todoList.length; index++) {
      String todo = todoList[index];
      int no = index + 1;

      if (todo != null) {
        System.out.println(no + ". " + todo);
      }
    }
  }

  public static void testShowTodoList() {
    todoList[0] = "Belajar Java Dasar";
    todoList[1] = "Studi Kasus Java Dasar : Aplikasi TodoList";
    showTodoList();
  }

  /** Menambah Todo ke List */
  public static void addTodoList(String todo) {
    // Cek apakah todoList sudah penuh
    boolean isFull = true;
    for (int index = 0; index < todoList.length; index++) {
      if (todoList[index] == null) {
        // TodoList masih ada yg kosong
        isFull = false;
        break;
      }
    }

    // Jika penuh, ubah size array jadi 2x lipat
    if (isFull) {
      String[] temporary = todoList;
      todoList = new String[todoList.length * 2];

      for (int index = 0; index < temporary.length; index++) {
        todoList[index] = temporary[index];
      }
    }

    // Tambahkan ke posisi array yg datanya null
    for (int index = 0; index < todoList.length; index++) {
      if (todoList[index] == null) {
        todoList[index] = todo;
        break;
      }
    }
  }

  public static void testAddTodoList() {
    for (int index = 0; index < 25; index++) {
      addTodoList("Contoh Todo Ke." + index);
    }

    showTodoList();
  }

  /** Menghapus Todo dari List */
  public static boolean removeTodoList(Integer number) {
    Integer todoIndexPosition = number - 1;

    if (todoIndexPosition >= todoList.length) {
      return false;
    } else if (todoList[todoIndexPosition] == null) {
      return false;
    } else {
      for (int i = todoIndexPosition; i < todoList.length; i++) {
        if (i == todoList.length - 1) {
          todoList[i] = null;
        } else {
          todoList[i] = todoList[i + 1];
        }
      }
      return true;
    }
  }

  public static void testRemoveTodoList() {
    addTodoList("Satu");
    addTodoList("Dua");
    addTodoList("Tiga");
    addTodoList("Empat");
    addTodoList("Lima");

    boolean result = removeTodoList(20);
    System.out.println(result);

    result = removeTodoList(7);
    System.out.println(result);

    result = removeTodoList(2);
    System.out.println(result);

    showTodoList();
  }

  public static String input(String info) {
    System.out.print(info + " : ");
    String data = scanner.nextLine();
    return data;
  }

  public static void testInput() {
    String name = input("Nama");
    System.out.println("Hi " + name);

    String channel = input("Channel");
    System.out.println(channel);
  }

  /** Menampilkan view TodoList */
  public static void viewShowTodoList() {
    while (true) {
      showTodoList();

      System.out.println();
      System.out.println("MENU : ");
      System.out.println("1. Tambah");
      System.out.println("2. Hapus");
      System.out.println("x. Keluar");

      String input = input("Pilih");
      if (input.equals("1")) {
        viewAddTodoList();
      } else if (input.equals("2")) {
        viewRemoveTodoList();
      } else if (input.equals("x")) {
        break;
      } else {
        System.out.println("Pilihan tidak dimengerti");
      }
    }
  }

  public static void testViewShowTodoList() {
    addTodoList("Satu");
    addTodoList("Dua");
    addTodoList("Tiga");
    addTodoList("Empat");
    addTodoList("Lima");

    viewShowTodoList();
  }

  /** Menampilkan view menambah TodoList */
  public static void viewAddTodoList() {
    System.out.println("MENAMBAH TODO LIST");

    String todo = input("Todo (x Jika Batal)");

    if (todo.equals("x")) {
      // batal
    } else {
      addTodoList(todo);
    }
  }

  public static void testViewAddTodoList() {
    addTodoList("satu");
    addTodoList("dua");
    addTodoList("tiga");

    viewAddTodoList();

    showTodoList();
  }

  /** Menampilkan view menghapus TodoList */
  public static void viewRemoveTodoList() {
    System.out.println("MENGHAPUS TODO LIST");

    String nomorTodo = input("Nomor Todo yang dihapus (x Jika Batal)");

    if (nomorTodo.equals("x")) {
      // batal
    } else {
      boolean success = removeTodoList(Integer.valueOf(nomorTodo));
      if (!success) {
        System.out.println("Gagal menghapus todo list : " + nomorTodo);
      }
    }
  }

  public static void testViewRemoveTodoList() {
    addTodoList("satu");
    addTodoList("dua");
    addTodoList("tiga");

    showTodoList();

    viewRemoveTodoList();

    showTodoList();
  }
}
