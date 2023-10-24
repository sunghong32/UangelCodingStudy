//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/10/23.
//  백준 17140: 이차원 배열과 연산
//  메모리: 79524 KB
//  시간: 24 ms

import Foundation

let rck = readLine()!.split(separator: " ").map { Int($0)! }
let r = rck[0] - 1
let c = rck[1] - 1
let k = rck[2]

var A: [[Int]] = []
var count = 0

for _ in 0..<3 {
    A.append(readLine()!.split(separator: " ").map { Int($0)! })
}

func calculationR(array: [[Int]]) -> [[Int]] {
    var tempA = array

    for i in 0..<tempA.count {
        let tempDic: [Int: Int] = tempA[i].reduce(into: [:]) { countDic, num in
            if num != 0 {
                countDic[num] = (countDic[num] ?? 0) + 1
            }
        }

        let sortedDic = tempDic.sorted {
            if $0.value == $1.value {
                return $0.key < $1.key
            } else {
                return $0.value < $1.value
            }
        }

        tempA[i] = sortedDic.flatMap { [$0.key, $0.value] }
    }

    let maxCount = tempA.map { $0.count }.max() ?? 0

    for (index, array) in tempA.enumerated() {
        let difference = maxCount - array.count

        if difference > 0 {
            tempA[index].append(contentsOf: Array(repeating: 0, count: difference))
        }

        if array.count > 100 {
            tempA[index] = Array(array.prefix(100))
        }
    }

    return tempA
}

func transposeArray(array: [[Int]]) -> [[Int]] {
    let transpos = array[0].indices.map { column in
        array.map { row in
            row[column]
        }
    }

    return transpos
}

func calculationC(array: [[Int]]) -> [[Int]] {
    var tempA = array

    tempA = transposeArray(array: tempA)
    
    tempA = calculationR(array: tempA)

    for (index, array) in tempA.enumerated() {
        if array.count > 100 {
            tempA[index] = Array(array.prefix(100))
        }
    }

    tempA = transposeArray(array: tempA)

    return tempA
}

func timer() -> Int {
    while count <= 100 {
        if r < A.count && c < A[0].count {
            if A[r][c] == k { return count }
        }

        if A[0].count <= A.count {
            A = calculationR(array: A)
        } else {
            A = calculationC(array: A)
        }

        count += 1
    }

    return -1
}

print(timer())
