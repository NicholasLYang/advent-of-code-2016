class DirectionParser
  KEYPAD = [
    [0, 0, 1, 0, 0],
    [0, 2, 3, 4, 0],
    [5, 6, 7, 8, 9],
    [0, 'A', 'B', 'C', 0],
    [0, 0, 'D', 0, 0]
  ]

  def read_file(file_name)
    code = []
    File.readlines(file_name).each do |line|
      code << read_line(line)
    end
    puts code.to_s
  end

  def read_line(line)
    pointer = [2, 0]
    line.split('').each do |char|
      pointer = move_pointer(pointer, char)
    end
    return KEYPAD[pointer[0]][pointer[1]]
  end

  def move_pointer(pointer, char)
    delta_x = 0
    delta_y = 0
    delta_x = 1 if char == 'R'
    delta_x = -1 if char == 'L'
    delta_y = 1 if char == 'D'
    delta_y = -1 if char == 'U'
    return [pointer[0] + delta_x,
            pointer[1] + delta_y] if check_pointer(pointer, delta_x, delta_y)
    return pointer
  end

  def check_pointer(pointer, delta_x, delta_y)
    x_boundaries = pointer[0] + delta_x > -1 && pointer[0] + delta_x < 5
    y_boundaries = pointer[1] + delta_y > -1 && pointer[1] + delta_y < 5
    pointer_valid = x_boundaries && y_boundaries && KEYPAD[pointer[0]][pointer[1]] != 0
    return pointer_valid
  end

end
d = DirectionParser.new
d.read_file("instructions.txt")
