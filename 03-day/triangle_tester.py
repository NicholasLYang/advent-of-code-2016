def testTriangle(sides):
    return sides[0] + sides[1] > sides[2] and sides[2] + sides[0] > sides[1] and sides[2] + sides[1] > sides[0]

def main():
    numOfTriangles = 0
    triangles = [[0, 0, 0],[0, 0, 0],[0, 0, 0]]
    counter = 0
    fileObject = open("input.txt", "r")
    for line in fileObject:
        line  = " ".join(line.split())
        numbers = line.split(" ")
        for i in range(0, 3):
            triangles[i][counter] = int(numbers[i])
        counter = counter + 1
        if counter == 3:
            for i in range (0, 3 ):
                if testTriangle(triangles[i]):
                    numOfTriangles = numOfTriangles + 1
            counter = 0
            triangles = [[0, 0, 0], [0, 0, 0], [0, 0, 0]]
    print numOfTriangles


main()
